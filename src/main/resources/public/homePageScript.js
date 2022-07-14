let baseUrl = "http://localhost:8081"; //might have to change port

function logout(){
    sessionStorage.clear();
}

async function PopulateBuilds(){

    let foundUser = (sessionStorage.getItem('inUser'));

    if (foundUser == null){
        console.log("your not logged in!");
        // return;
    }

    else{
        let res = await fetch(`
                ${baseUrl}/users/${foundUser.id}/builds`, //endpoint?
                {
                    method: 'GET',
                    header: {'Content-Type': 'application/json'},
                    
                    
                });

        let resJson = await res.json()

        .then(resp =>{
            console.log(resp);

            let table = document.getElementById("buildTable");

                


        })





                
    }
}

