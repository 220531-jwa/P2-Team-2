let baseUrl = "http://localhost:8081/userbuilds";

async function getOtherUserBuilds() {

    
    
    
    let res = await fetch(`${baseUrl}/`); 

    if (res.status == 200) {
        let data = await res.json();
        console.log(data);
        populateData(data);
    } else {
        console.log("It got away!");
    }

};



function showContent() {}