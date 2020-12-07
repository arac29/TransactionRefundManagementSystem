window.onload = function(){
    /** ***************  other employees REQUESTS ****************** */
    let xhr = new XMLHttpRequest();
    const url = "http://localhost:9094/readAllReimbursements";
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200){
            let reimbursementList = JSON.parse(xhr.responseText);
            console.log(reimbursementList);
            reimbursementList.forEach(element => {
                let table=document.getElementById("other-reimbursement");
                let tableRow = document.createElement("tr");
                /** *************** table 1 **************/
                let employeeId = document.createElement("td");
                let eventNumber = document.createElement("td");
                let submit_date = document.createElement("td");
                let amount_requested = document.createElement("td");
                let adjusted_amount = document.createElement("td");
                let notes = document.createElement("td");
                let add_notes=document.createElement("td");
                let dirsup=document.createElement("td");
                let dehead=document.createElement("td");
                let benco=document.createElement("td");
                let reimbursementStatusId= document.createElement("td");
                let uploads= document.createElement("td");
                let estimated = document.createElement("td");
                /*********LINK *******/
                let id_link= document.createElement("a");
                let gradelink = document.createTextNode(element.employeeId); 
                id_link.appendChild(gradelink);
                id_link.href="employee-info.html/"+"?employeeId="+element.employeeId;
                id_link.title=element.employeeId;
                /********* values *******/
                adjusted_amount.innerHTML="$ "+ element.adjustedAmount;
                eventNumber.innerHTML=element.eventId;
                submit_date.innerHTML = element.dateSubmition;
                amount_requested.innerHTML ="$ "+ element.amountRequested;
                notes.innerHTML = element.notes;
                dirsup.innerHTML=element.directorSupervisorApprovalDate;
                dehead.innerHTML=element.departmentHeadApprovalDate;
                benco.innerHTML=element.benCoApprovalDate;
                let status=check_status(element.reimbursementStatusId);
                reimbursementStatusId.innerHTML=status;
                uploads.innerHTML=element.updateFileId;
                /********* dom nodes *******/
                employeeId.appendChild(id_link);
                tableRow.appendChild(employeeId);
                tableRow.appendChild(eventNumber);
                tableRow.appendChild(submit_date);
                tableRow.appendChild(amount_requested);
                tableRow.appendChild(notes);
                tableRow.appendChild(dirsup);
                tableRow.appendChild(dehead);
                tableRow.appendChild(benco);
                tableRow.appendChild(uploads);
                tableRow.appendChild(adjusted_amount);
                tableRow.appendChild(reimbursementStatusId);
                tableRow.appendChild(add_notes);
                table.appendChild(tableRow);
                /************* button ******** */
                let noteForm = document.createElement("form");
                noteForm.action = "request-information.html";
                let inputx = document.createElement("input");
                let inputy = document.createElement("input");
                /******* id + button create  *****/
                inputx.type = "hidden";
                inputx.name = "reimbursementId";
                inputx.value = element.reimbursementId;
                inputy.type = "submit";
                inputy.className="btn btn-success";
                inputy.value = "Add note";

                noteForm.appendChild(inputx);
                noteForm.appendChild(inputy);
                add_notes.appendChild(noteForm);
            });
        }
    }
    xhr.open("GET", url, true);
    xhr.send();

    /** ***************** other employees Events ******************* */
    let xhr4 = new XMLHttpRequest();
    const url4 = "http://localhost:9094/readAllEvents";
    xhr4.onreadystatechange = function () {
        console.log(xhr4.readyState);
        if (this.readyState == 4 && this.status == 200){
            let eventList = JSON.parse(xhr4.responseText);
            eventList.forEach(element => {
                let table=document.getElementById("other-events");
                let tableRow = document.createElement("tr");
                /** *************** table 2 **************/
                let eventNumber=document.createElement("td");
                let nameCol = document.createElement("td");
                let StartDate = document.createElement("td");
                let location= document.createElement("td");
                let gradeAss= document.createElement("td");
                let description=document.createElement("td");
                let gradeSub = document.createElement("td");
                let g_ass=check_grade(element.gradeId);
                
                nameCol.innerHTML = element.name;
                StartDate.innerHTML = element.startDate + " -> "+ element.endDate;
                location.innerHTML = element.location;
                gradeAss.innerHTML =g_ass;
                gradeSub.innerHTML =element.employeeGrade;
                eventNumber.innerHTML=element.eventId;
                description.innerHTML=element.description;
                
                tableRow.appendChild(eventNumber);
                tableRow.appendChild(nameCol);
                tableRow.appendChild(location);
                tableRow.appendChild(StartDate);
                tableRow.appendChild(description);
                tableRow.appendChild(gradeSub);
                tableRow.appendChild(gradeAss);
                table.appendChild(tableRow);
            });
        }
    }
    xhr4.open("GET", url4, true);
    xhr4.send();
    /**   ******************** MY requests ************************/
    let xhr1 = new XMLHttpRequest();
    const url1 = "http://localhost:9094/readReimbursements";
    xhr1.onreadystatechange = function () {
        console.log(xhr1.readyState);
        if (this.readyState == 4 && this.status == 200){
            let reimbursementList = JSON.parse(xhr1.responseText);
            console.log(reimbursementList);
            reimbursementList.forEach(element => {
                let table=document.getElementById("my-reimbursement");
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
                updateCol.appendChild(updateForm);
            });
        }
    }
    xhr1.open("GET", url1, true);
    xhr1.send();
    /** ******************** MY events ************************/
    let xhr2 = new XMLHttpRequest();
    const url2 = "http://localhost:9094/readEvents";
    xhr2.onreadystatechange = function () {
        console.log(xhr2.readyState);
        if (this.readyState == 4 && this.status == 200){
            //console.log(xhr1.responseText);
            let eventList = JSON.parse(xhr2.responseText);
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
                
                table.appendChild(tableRow);
            });
        }
    }
    xhr2.open("GET", url2, true);
    xhr2.send();
    /** ******************** helpers? ************************/
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
}
/** ******************** REDIRECT TO FORM ************************/
function redirect_form(){
window.location.replace("http://localhost:9094/newRequest");
}
