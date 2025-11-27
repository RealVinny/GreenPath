
function irParaApp(event) {
    event.preventDefault(); // impede o envio real do form
    // aqui, por enquanto, só redireciona pro app principal
    window.location.href = "index.html";
}

function loginAttempt(){
    let senha = document.getElementById("senha").value;
    let email = document.getElementById("email").value;
    const data={
        email:email,
        senha:senha
    }

    const bodyJSON = JSON.stringify(data)

    fetch("api/user/login/",{
        method :"POST",
        headers:{
            "Content-type":"application/json"
        },
        body: bodyJSON
    }).then(response=>{
        if(!response.ok){
            alert("email ou senha incorretos")
        }else{
            return response.json()
        }
        }
    ).then(
        data=>{
            if(!data) return;
            localStorage.setItem("token", data.token);
            window.location.href = "../index.html"
        }
    ).catch(err=>{
        console.error("Erro na requisição ->", err)
    })
}


