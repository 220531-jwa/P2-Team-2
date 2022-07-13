let baseUrl = "http://localhost:8081";
async function searchForParts(){

    let min = document.getElementById("priceFloorInput").value;
    let max = document.getElementById("priceCeilingInput").value;

    //add things to change it to min/max if null/0

    // console.log(min);
    // console.log(max);
    // let typeSelector = document.getElementById("partTypeSelector");
    // let type;

    // if (typeSelector.options[typeSelector.selectedIndex].value == 'ALL'){
    //     // console.log('nice');
        
    // }
    // console.log(typeSelector.options[typeSelector.selectedIndex].value);

    let res = await fetch(
        `${baseUrl}/search?priceFloor=${min}&priceCeiling=${max}`,
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
