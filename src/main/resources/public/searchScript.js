// let baseUrl = "http://localhost:8081";
async function searchForParts(){







    let min = document.getElementById("priceFloorInput").value;
    if (min.length === 0)
        {
            min = 0;
        }

    let max = document.getElementById("priceCeilingInput").value;
    if (max.length ===0 || max == 0){
        max = 99999999.99; 
    }

    


    console.log(`min: ${min}`);
    console.log(`max: ${max}`);
    // let typeSelector = document.getElementById("partTypeSelector");
    // let type;

    // if (typeSelector.options[typeSelector.selectedIndex].value == 'ALL'){
    //     // console.log('nice');
        
    // }
    // console.log(typeSelector.options[typeSelector.selectedIndex].value);

    let res = await fetch(
        `${baseUrl}/search?priceFloor=${min}&priceCeiling=${max}`,
        // `${baseUrl}/search`,
        
        {
            method: 'GET',
            header: {'Content-Type': 'application/json'}
            

        });
        let resJson = await res.json()
        .then((resp)=>{

        console.log(resp);



        })

        .catch((error)=>{console.log(error);
        
        });
}
