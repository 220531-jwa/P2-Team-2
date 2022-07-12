let baseUrl = "http://localhost:8081"; //might have to change port

async function login(){
    console.log("BUTTON CLICKED");
    let username = document.getElementById("usernameInput").value;
    let pass = document.getElementById("passwordInput").value;

    let user = {
        username: username,
        pass: pass,

    }

    let userJson = JSON.stringify(user);
    console.log(userJson);

    let res = await fetch(
        `${baseUrl}/login`,
        {
            method: 'POST',
            header: {'Content-Type': 'application/json'},
            body: userJson
        });
        
        let resJson = await res.json()
        .then((resp)=>{
            console.log(resp);
            if (res.status ===200){
                //login logic here
                console.log("IT WORKED");
                window.location.assign("home.html");
            }
            else{
                alert(resp.message); 
  
            }
        })
   
        // sessionStorage.setItem('inUser', JSON.stringify(resp));
                
        

        
        .catch((error)=>{console.log(error);
           
        
    }); 
        
}

async function createAccount(){

    let username = document.getElementById("usernameInput").value;
    let pass = document.getElementById("passwordInput").value;

    let user = {
        username: username,
        pass: pass,

    }

    let userJson = JSON.stringify(user);
    console.log(userJson);

    let res = await fetch(
        `${baseUrl}/createAccount`,
        {
            method: 'POST',
            header: {'Content-Type': 'application/json'},
            body: userJson
        });
        
        let resJson = await res.json()
        .then((resp)=>{
            console.log(resp);
            if (res.status ===200){
                //login logic here
                console.log("IT WORKED");
                
            }
            else{
                alert(resp.message); 
  
            }
        })
        // currentUser = resp.name;
        // sessionStorage.setItem('inUser', JSON.stringify(resp));
                
        // window.location.assign("Employeehomepage.html");
        // console.log(currentUser);
        
        .catch((error)=>{console.log(error); 
            
    }); 
        
}