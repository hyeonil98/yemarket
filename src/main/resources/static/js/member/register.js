document.addEventListener("DOMContentLoaded", function () {
    const registerEmail = document.getElementById("registerEmail");
    const registerPw = document.getElementById("registerPw");
    const registerPhone = document.getElementById("registerPhone");

    const registerPwChk = document.getElementById("registerPwChk");

    const chkFields = [
        {id: "registerEmail", type: "email"},
        {id: "registerPw", type: "pw"},
        {id: "registerPwChk", type: "pwChk"},
        {id: "registerPhone", type: "phone"}

    ];

    registerPhone.addEventListener("keyup", function () {
        registerPhone.value = formatPhoneNumber(registerPhone.value);
    });

    chkFields.forEach(({id, type}) => {
        const input = document.getElementById(id);
        const registerSubmitBtn = document.getElementById("registerSubmitBtn")

        input.addEventListener("blur", () => {
            const isValid = validateField(type, input);
            const alertP = input.parentElement.nextElementSibling;

            if (!isValid) {
                alertP.style.display = "block";
            } else {
                alertP.style.display = "none";
            }

            if (type === 'email') {
                if (chkDuplicateEmail(input.value)) {
                    alertP.innerHTML = "중복된 이메일 입니다."
                    alertP.style.display = "block";
                }else{
                    alertP.innerHTML = "올바른 이메일 주소를 입력해주세요."
                    alertP.style.display = "none";
                }
            }

            registerSubmitBtn.disabled = !validateRegisterBtn();
        });
    });
});

function pwChk(){
    const pw = document.getElementById("registerPw").value;
    const pwChk = document.getElementById("registerPwChk").value;
    return pw === pwChk;
}

function chkDuplicateEmail(email) {
    fetch("/dupChkEmail", {
        method: "POST",
        headers: {
            "content-Type": "application/json"
        },
        body: JSON.stringify({email})
    })
        .then(res => {
            if (!res.ok) throw new Error("서버 오류");
            return res.json();
        })
        .then(data => {
            if (data.exists) {
                alert("이미 사용중인 이메일입니다.");
            } else {
                alert("사용 가능한 이메일 입니다.")
            }
        })
        .catch(err => {
            alert("중복 확인 실패 :" + err);
        });
}

function validateField(type, obj) {
    const pattern = patterns[type];
    if (type === 'pwChk') return pwChk();
    else return pattern.test(obj.value);
}

function validateRegisterBtn() {
    let flag = true;
    const chkFields = document.querySelectorAll(".registerBtn");
    const alerts = document.querySelectorAll(".alert");

    chkFields.forEach(item => {
        const value = item.value;
        if (value === '') {
            flag = false;
        }
    });

    alerts.forEach(item => {
        const isAlert = item.style.display;
        if (isAlert === 'block') {
            flag = false;
        }
    })
    return flag;
}

function formatPhoneNumber(value) {
    // 숫자만 남기기
    const onlyNums = value.replace(/\D/g, '');

    if (onlyNums.length < 4) {
        return onlyNums;
    } else if (onlyNums.length < 8) {
        return onlyNums.slice(0, 3) + '-' + onlyNums.slice(3);
    } else {
        return onlyNums.slice(0, 3) + '-' + onlyNums.slice(3, 7) + '-' + onlyNums.slice(7, 11);
    }
}