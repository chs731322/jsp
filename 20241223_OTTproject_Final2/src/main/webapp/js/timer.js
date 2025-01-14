window.onload = () => {
    document.querySelectorAll(".payment-button").forEach(button => {
        button.addEventListener("click", (event) => {
            const confirmation = confirm("결제하시겠습니까?");
            if (!confirmation) {
                event.preventDefault();
                return;
            }

            const card = event.target.closest(".card");
            const timerDisplay = card.querySelector(".timer-display");
            const paymentButton = card.querySelector(".payment-button");
            const ottInfo = card.querySelector(".ott-info");
            const statusHeading = card.querySelector("h3");
            const pendingMessage = Array.from(card.querySelectorAll("p"))
                .find(p => p.textContent.includes("결제가 완료되지 않았습니다.")); // 정확히 "결제가 완료되지 않았습니다." 문구 찾기

            // 상태 변경
            statusHeading.textContent = "결제 완료";

            // "결제가 완료되지 않았습니다." 문구 제거
            if (pendingMessage) {
                pendingMessage.remove(); // 요소 자체 제거
            }

            // 숨김 처리 및 타이머 표시
            paymentButton.style.display = "none";
            ottInfo.style.display = "block";
            timerDisplay.style.display = "block";

            // 30초 카운트다운
            let remainingTime = 60;
            const intervalId = setInterval(() => {
                timerDisplay.textContent = `남은 시간: ${remainingTime}초`;
                remainingTime--;

                if (remainingTime < 0) {
                    clearInterval(intervalId);
                    timerDisplay.style.display = "none";
                    paymentButton.style.display = "block";
                    ottInfo.style.display = "none";
                    statusHeading.textContent = "결제 대기 상태"; // 타이머 종료 후 다시 대기 상태로 변경
                    if (pendingMessage) {
                        card.appendChild(pendingMessage); // 문구 복구
                        pendingMessage.style.display = "block";
                    }
                }
            }, 1000);
        });
    });
};
