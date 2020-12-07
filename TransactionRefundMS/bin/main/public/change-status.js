window.onload = function(){

    let parameters = location.search.substring(1).split("?");
    let param = parameters[0].split("=");

    let reimbursementId = param[1];
    console.log(parameters);

    let xhr = new XMLHttpRequest();
    const url = "http://localhost:9094/readReimbursementById/" + reimbursementId;
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);
        if (this.readyState == 4 && this.status == 200){
            //console.log(xhr.responseText);
            let reimbursement= JSON.parse(xhr.responseText);
            console.log(reimbursement);
            let cost=document.getElementById("cost");
            cost.value=reimbursement.amountRequested;

            let form=document.getElementById("updateReimbursement");
            form.action = "http://localhost:9094/updateCost/" +  reimbursementId;
            

        }
    }
        xhr.open("GET", url, true);

    xhr.send();
}
    
