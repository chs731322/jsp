<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>네이버 이미지 검색</title>
  <style>
  	h2{
  		text-align: center;
  	}
  	#searchForm{
  		text-align: center;
  	}
  	#searchResult{
  		width : 1200px;
  		margin:0 auto;
  		display: flex;
  		flex-flow: row wrap;
  		justify-content: space-between;
  		gap : 10px;
  	}
  	#searchResult > div {
  		max-width: 300px;
  	}
  	
  	#searchResult > div  img{
  		width:100%;
  	}
  </style>
  <script>
    window.onload = () => {
      const txtSearch = document.querySelector('#txtSearch');
      const btnSearch = document.querySelector('#btnSearch');
      const searchResult = document.querySelector('#searchResult');

      btnSearch.onclick = () => {
        const searchValue = txtSearch.value;
        const url = `./naverImgSearch.do?search=\${searchValue}`;

        fetch(url)
        .then(response => response.json())
        .then(json => {
          console.log(json);
          const items = json.items;
          let tag ='';
          items.forEach(item => {
            tag += '<div>';
            tag += `<img src='\${item.link}'/>`;
            tag += `<p>\${item.title}</p>`;
            tag += '</div>';
          });
          searchResult.innerHTML = tag;
          
        });
      };
    }
  </script>
</head>
<body>
	<h2>네이버 이미지 검색 페이지</h2>
	<div id="searchForm">
 		 <input type="text" id="txtSearch" placeholder="검색어 입력"/>
		  <button id="btnSearch">검색</button>
	</div>
  <hr>
  <div id="searchResult"></div>
</body>
</html>