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
                ${baseUrl}/users/${JSON.parse(foundUser).id}/builds`, //endpoint?
                {
                    method: 'GET',
                    header: {'Content-Type': 'application/json'},
                    
                    
                });

        let resJson = await res.json()

        .then((resp) =>{
            console.log(resp);

            let table = document.getElementById("buildTable");

             for (const entry of resp){

             var row = table.insertRow(-1);   

             var cell0 = row.insertCell(0);
             var cell1 = row.insertCell(1);
             var cell2 = row.insertCell(2);
             var cell3 = row.insertCell(3);
             var cell4 = row.insertCell(4);
             var cell5 = row.insertCell(5);
             var cell6 = row.insertCell(6);
             var cell7 = row.insertCell(7);
            //  var cell8 = row.insertCell(8);
             
            cell0.innerText = entry.buildId;
            cell1.innerText = entry.buildName;
            cell2.innerText = entry.moboName;
            cell3.innerText = entry.cpuName;

            let ramy = entry.ramName;
            if (!entry.hasFourRAM)
                {ramy +="x2"
            }
            else{
                ramy +="x4"
            }
            cell4.innerText = ramy;
            
            
            cell5.innerText = entry.storageName;
            cell6.innerText = entry.psuName;
            cell7.innerText = entry.caseName;
            // cell8.innerText = entry.caseId;

            // cell8.innerText = 


             }  
        })

        .catch((error)=>{console.log(error);
            console.log(error);
            });
                
    }
}

