let baseUrl = "http://localhost:8081"; //might have to change port

async function login(){
    // console.log("BUTTON CLICKED");
    let username = document.getElementById("usernameInput").value;
    let pass = document.getElementById("passwordInput").value;

    if (username.trim() ==="" || pass.trim() === ""){
        alert("please fill both inputs");
        return;
    }


    let user = {
        username: username,
        pass: pass,

    }

    let userJson = JSON.stringify(user);
    // console.log(userJson);

    let res = await fetch(
        `${baseUrl}/login`,
        {
            method: 'POST',
            header: {'Content-Type': 'application/json'},
            body: userJson
        });
        
        let resJson = await res.json()
        .then((resp)=>{
            // console.log(resp);
            if (res.status ===200){
                //login logic here
                // console.log("IT WORKED");
                window.location.assign("home.html");
                sessionStorage.setItem('inUser', JSON.stringify(resp));
                console.log(JSON.parse(sessionStorage.getItem('inUser')));
            }
            else{
                alert(resp.message); 
  
            }
        })
   
        .catch((error)=>{console.log(error);
        
        
    }); 
        
}

async function createAccount(){

    let username = document.getElementById("usernameInput").value;
    let pass = document.getElementById("passwordInput").value;

    if (username.trim() ==="" || pass.trim() === ""){
        alert("please fill both inputs");
        return;
    }

    let user = {
        username: username,
        pass: pass,

    }

    let userJson = JSON.stringify(user);
    // console.log(userJson);

    let res = await fetch(
        `${baseUrl}/createAccount`,
        {
            method: 'POST',
            header: {'Content-Type': 'application/json'},
            body: userJson
        });
        
        let resJson = await res.json()
        .then((resp)=>{
            // console.log(resp);
            if (res.status ===200){
                //login logic here
                // console.log("IT WORKED");
                window.location.assign("home.html");
                sessionStorage.setItem('inUser', JSON.stringify(resp));
                
            }
            else{
                alert(resp.message); 
  
            }
        })
       
        
        .catch((error)=>{console.log(error); 
            
    }); 
        
}