window.onload = function(){

    let parameters = location.search.substring(1).split("?");
    let param = parameters[0].split("=");
    let reimbursementId = param[1];

    let form=document.getElementById("upload");
    form.action = "http://52.188.8.54/uploadFile/" +  reimbursementId;
}
    

