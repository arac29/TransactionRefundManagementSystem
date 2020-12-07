window.onload=function(){
// ********************* SHOW TABLE WITH REIMBURSEMENTS BY EMPLOYEE ID****/
    let xhr = new XMLHttpRequest();
    const url = "http://localhost:9094/readReimbursements";
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);
        if (this.readyState == 4 && this.status == 200){
            let reimbursementList = JSON.parse(xhr.responseText);
            console.log(reimbursementList);
            reimbursementList.forEach(element => {
                let table=document.getElementById("reimbursement-table");
                let tableRow = document.createElement("tr");
                let submit_date = document.createElement("td");
                let amount_requested = document.createElement("td");
                let notes = document.createElement("td");
                let estimated = document.createElement("td");
                let reimbursementStatusId= document.createElement("td");
                let uploads= document.createElement("td");
                let updateCol = document.createElement("td");

                submit_date.innerHTML = element.dateSubmition;
                amount_requested.innerHTML ="$ "+ element.amountRequested;
                notes.innerHTML = element.notes;
                let status=check_status(element.reimbursementStatusId);
                reimbursementStatusId.innerHTML=status;
                estimated.innerHTML="$ "+element.adjustedAmount;
                uploads.innerHTML=element.updateFileId;

                tableRow.appendChild(submit_date);
                tableRow.appendChild(notes);
                tableRow.appendChild(amount_requested);
                tableRow.appendChild(estimated);
                tableRow.appendChild(reimbursementStatusId);
                tableRow.appendChild(uploads);
                tableRow.appendChild(updateCol);
                table.appendChild(tableRow);
                /********************* */
                let updateForm = document.createElement("form");
                updateForm.action = "updateReimbursement.html";
                let inputx = document.createElement("input");
                let inputy = document.createElement("input");

                inputx.type = "hidden";
                inputx.name = "eventId";
                inputx.value = element.reimbursementId;

                inputy.type = "submit";
                inputy.className="btn btn-info";
                inputy.value = "Upload";

                updateForm.appendChild(inputx);
                updateForm.appendChild(inputy);

                // gradeCol.appendChild(addGrade);
                updateCol.appendChild(updateForm);
            });
        }
    }
    xhr.open("GET", url, true);
    xhr.send();
// ********************* POPULATE TABLE WITH EVENT INFO BY EMPLOYEE ID****/
    let xhr1 = new XMLHttpRequest();
    const url1 = "http://localhost:9094/readEvents";
    xhr1.onreadystatechange = function () {
        console.log(xhr1.readyState);
        if (this.readyState == 4 && this.status == 200){
            //console.log(xhr1.responseText);
            let eventList = JSON.parse(xhr1.responseText);
            console.log(eventList);
            eventList.forEach(element => {
                let table=document.getElementById("event-table");
                let tableRow = document.createElement("tr");
                let nameCol = document.createElement("td");
                let StartDate = document.createElement("td");
                let location= document.createElement("td");
                let gradeAss= document.createElement("td");
                let description=document.createElement("td");
                let gradeSub = document.createElement("td");

                //let g_sub=check_grade(element.employeeGrade);
                let g_ass=check_grade(element.gradeId);
                
                nameCol.innerHTML = element.name;
                StartDate.innerHTML = element.startDate + " -> "+ element.endDate;
                location.innerHTML = element.location;
                gradeAss.innerHTML =g_ass;
                gradeSub.innerHTML =element.employeeGrade;

                description.innerHTML=element.description;

                tableRow.appendChild(nameCol);
                tableRow.appendChild(location);
                tableRow.appendChild(StartDate);
                tableRow.appendChild(description);
                tableRow.appendChild(gradeSub);
                tableRow.appendChild(gradeAss);
               // tableRow.appendChild(updateCol);
                if (element.employeeGrade=="" || element.employeeGrade==undefined){
                    let gradeCol=document.createElement("td");
                    let updateForm = document.createElement("form");
                    updateForm.action = "submitGrade.html";
                    let inputx = document.createElement("input");
                    let inputy = document.createElement("input");

                    inputx.type = "hidden";
                    inputx.name = "eventId";
                    inputx.value = element.eventId;

                    inputy.type = "submit";
                    inputy.className="btn btn-info";
                    inputy.value = "Add grade";

                    updateForm.appendChild(inputx);
                    updateForm.appendChild(inputy);
                    gradeCol.appendChild(updateForm);
                    tableRow.appendChild(gradeCol);
                }
                table.appendChild(tableRow);

                // let updateForm = document.createElement("form");
                // updateForm.action = "updateEvent.html";
                // let inputx = document.createElement("input");
                // let inputy = document.createElement("input");

                // inputx.type = "hidden";
                // inputx.name = "eventId";
                // inputx.value = element.eventId;

                // inputy.type = "submit";
                // inputy.className="btn btn-info";
                // inputy.value = "Update";

                // updateForm.appendChild(inputx);
                // updateForm.appendChild(inputy);
                // updateCol.appendChild(updateForm);
           });
        }
    }
    xhr1.open("GET", url1, true);
    xhr1.send();


document.getElementById("info").addEventListener("click",function(){
    let x=document.getElementById("submit-info");
    if (x.style.visibility==="hidden") {
        x.style.visibility="visible";
    }
    else{
        x.style.visibility="hidden";
    }
});


function check_status(status){
    switch (status) {
    case 1:
        return "Pending";
    case 2:
        return "Grade Pending";
    case 3:
        return "Approval Pending";
    case 4:
        return "Awarded";
    case 5:
        return "Cancelled";
    case 6:
        return "Urgent";
    case 7:
        return "Denied";
    }
}
function check_grade(grade){
    switch(grade){
        case 0:
            return "None";
        case 1:
            return "A";
        case 2:
            return "B";
        case 3:
            return "C";
        case 4:
            return "D";
        case 5:
            return "F";
    }
}


};
function send_info(reim_id) {
    console.log("send info function");
    console.log(reim_id);
}

// NEEED TOOOO CHANGE THIS WHEN DEPLOYING TO AZURE
function redirect_form(){
    window.location.replace("http://localhost:9094/newRequest");
}
function create_options_row(reim_id){
    
}
function upload_file(reim_id, text,file){
    
}

