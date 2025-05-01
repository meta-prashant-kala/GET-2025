let index = 0;

const ptag = document.getElementById("person-name")

const employeeForm = document.getElementById("employee-form");
const employeeFormInputDiv= employeeForm.getElementsByTagName("div");
employeeFormInputDiv[index].lastElementChild.focus();
employeeFormInputDiv[index].lastElementChild.addEventListener("keypress", handleEmpSectInputKeyPress);


const vehicleForm = document.getElementById("vehicle-form");
const vehicleFormInputDiv= vehicleForm.getElementsByTagName("div");

const feedbackForm = document.getElementById("feedback-section");
const feedbackFormInputDiv= feedbackForm.getElementsByTagName("div");


function handleEmpSectInputKeyPress(event) {
    if (event.key === "Enter") {
        employeeFormInputDiv[index].lastElementChild.removeEventListener("keypress", handleEmpSectInputKeyPress);
        employeeFormInputDiv[index].classList.remove('d-flex');
        employeeFormInputDiv[index].classList.add('d-none');
        if (index == 0) {
            ptag.innerText = `Hi ${employeeFormInputDiv[index].lastElementChild.value}, tell us about yourself`

        }
        index++;
        if (index == employeeFormInputDiv.length) {
            index=0;
            console.log("vehicle");
            document.getElementById("flush-collapseOne").classList.remove("show");
            document.getElementById("flush-collapseTwo").classList.add("show");
            vehicleFormInputDiv[index].classList.remove("d-none");
            vehicleFormInputDiv[index].classList.add("d-flex");
            vehicleFormInputDiv[index].lastElementChild.focus();
            vehicleFormInputDiv[index].lastElementChild.addEventListener("keypress", handleVehcSectInputKeyPress);
            ptag.innerText = "";
            return;
        }else{
            employeeFormInputDiv[index].classList.remove('d-none');
            employeeFormInputDiv[index].classList.add('d-flex');
            employeeFormInputDiv[index].lastElementChild.focus();
            employeeFormInputDiv[index].lastElementChild.addEventListener("keypress", handleEmpSectInputKeyPress);
        }
    }
}

function handleVehcSectInputKeyPress(event) {
    if (event.key === "Enter") {
        vehicleFormInputDiv[index].lastElementChild.removeEventListener("keypress", handleVehcSectInputKeyPress);
        vehicleFormInputDiv[index].classList.remove('d-flex');
        vehicleFormInputDiv[index].classList.add('d-none');
        index++;
        if (index == vehicleFormInputDiv.length) {
            index=0;
            feedbackFormInputDiv[index].classList.remove("d-none");
            feedbackFormInputDiv[index].classList.add("d-flex");
            feedbackFormInputDiv[index].lastElementChild.focus();
            feedbackFormInputDiv[index].lastElementChild.addEventListener("keypress", handleFeedBackSectInputKeyPress);
        }else {
            vehicleFormInputDiv[index].classList.remove('d-none');
            vehicleFormInputDiv[index].classList.add('d-flex');
            vehicleFormInputDiv[index].lastElementChild.focus();
            vehicleFormInputDiv[index].lastElementChild.addEventListener("keypress", handleVehcSectInputKeyPress);
        }
    }
}

function handleFeedBackSectInputKeyPress(event) {
    if (event.key === "Enter") {
        feedbackFormInputDiv[index].lastElementChild.removeEventListener("keypress", handleFeedBackSectInputKeyPress);
        feedbackFormInputDiv[index].classList.remove('d-flex');
        feedbackFormInputDiv[index].classList.add('d-none');
        index++;
        if (index >= feedbackFormInputDiv.length) {
            index=0;
            return;
        }
        else {
            feedbackFormInputDiv[index].classList.remove('d-none');
            feedbackFormInputDiv[index].classList.add('d-flex');
            feedbackFormInputDiv[index].lastElementChild.focus();
            feedbackFormInputDiv[index].lastElementChild.addEventListener("keypress", handleFeedBackSectInputKeyPress);
        }
    }
}
