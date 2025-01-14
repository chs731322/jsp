package controller;

import java.io.IOException;
import java.util.List;

import dto.GroupMemberDTO;
import dto.GroupsDTO;
import dto.UsersDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.GroupMemberService;
import service.GroupsService;
import view.ModelAndView;

public class OttViewController implements Controller {

    @Override
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        UsersDTO sessionUser = (UsersDTO) session.getAttribute("user");

        if (sessionUser == null) {
            response.getWriter().write("<script>alert('로그인이 필요합니다.'); location.href='login.jsp';</script>");
            return null;
        }

        // GroupMember 데이터 조회
        List<GroupMemberDTO> groupMemberList = GroupMemberService.getInstance().getGroupMemberById(sessionUser.getId());

        System.out.println("[DEBUG] Retrieved group members: " + groupMemberList.size());

        // 각 GroupMember에 OTT 정보를 추가
        for (GroupMemberDTO member : groupMemberList) {
            String gnoKey = member.getGno(); // GroupMemberDTO의 GNO
            System.out.println("[DEBUG] Processing GroupMember GNO: " + gnoKey);

            GroupsDTO groupInfo = GroupsService.getInstance().getGroupInfoByGno(gnoKey);
            if (groupInfo != null) {
                System.out.println("[DEBUG] Found matching Groups entry for GNO: " + groupInfo.getGno());
                System.out.println("[DEBUG] OTT ID: " + groupInfo.getOtt_id() + ", OTT Password: " + groupInfo.getOtt_password());

                // GroupMemberDTO에 OTT 정보를 추가
                member.setOttId(groupInfo.getOtt_id());
                member.setOttPassword(groupInfo.getOtt_password());
            } else {
                System.out.println("[DEBUG] No matching Groups entry found for GNO: " + gnoKey);
                member.setOttId("정보 없음");
                member.setOttPassword("정보 없음");
            }
        }

        // JSP로 데이터 전달
        request.setAttribute("group_member", groupMemberList);

        // JSP 경로 설정
        ModelAndView view = new ModelAndView();
        view.setPath("ott_view.jsp");
        view.setRedirect(false);

        return view;
    }
}
