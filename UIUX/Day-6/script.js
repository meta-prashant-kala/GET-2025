let employeeIndex = 0;
let vehicleIndex = 0;
let employeeId;
let selectedVehicleType;
let rupeePriceList;
let selectedPlan;
let planDuration;
let currencyType;
let isPlanSelected = false;
const ptag = document.getElementById("person-name");

document.getElementById('accordion-item-1').getElementsByTagName('div')[employeeIndex].classList.add('show');
const employeeForm = document.getElementById("employee-form");
const employeeFormInputDiv = employeeForm.getElementsByTagName("div");
employeeFormInputDiv[employeeIndex].classList.remove('d-none');
employeeFormInputDiv[employeeIndex].classList.add('d-flex');
employeeFormInputDiv[employeeIndex].lastElementChild.focus();
employeeFormInputDiv[employeeIndex].lastElementChild.addEventListener("keypress", handleEmpSectInputKeyPress);


function generateEmployeeId() {
    const formDivList = document.getElementById("employee-form").getElementsByTagName('div');
    employeeId = document.getElementById('vEmpId').value + Math.floor(Math.random() * 1000);
    return employeeId;
}

const vehicleForm = document.getElementById("vehicle-form");
const vehicleFormInputDiv = vehicleForm.getElementsByTagName("div");

function setPricingOfPricingSection(priceList) {
    document.getElementById("per-day-price").innerHTML = priceList[0];
    document.getElementById("per-month-price").innerHTML = priceList[1];
    document.getElementById("per-year-price").innerHTML = priceList[2];
}


function handleGenderInput(event) {
    employeeFormInputDiv[employeeIndex].classList.remove("d-flex");
    employeeFormInputDiv[employeeIndex].classList.add("d-none");
    employeeIndex++;
    employeeFormInputDiv[employeeIndex].classList.remove('d-none');
    employeeFormInputDiv[employeeIndex].classList.add('d-flex');
    employeeFormInputDiv[employeeIndex].lastElementChild.focus();
    employeeFormInputDiv[employeeIndex].lastElementChild.addEventListener("keypress", handleEmpSectInputKeyPress);
    employeeFormInputDiv[0].setAttribute('style', 'display:none !important');
    employeeIndex=3;
    ptag.innerText = "";
}


function handleEmpSectInputKeyPress(event) {
    document.getElementById("emp-error-field").textContent = "";
    const currentVal = event.key.length === 1 ? event.target.value + event.key : event.target.value;

    if (event.key === "Enter") {

        if (event.target.id === 'fullName' && currentVal.length <= 2) {
            document.getElementById("emp-error-field").textContent = "Name cannot be this short";
            return;
        } else if (event.target.id === 'email' && !(/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(currentVal))) {
            document.getElementById("emp-error-field").textContent = "Invalid email";
            return;
        } else if (event.target.id === 'password') {
            const passwordErrorTag = document.getElementById('emp-error-field');
            if (!(/[A-Z]/.test(currentVal))) {
                document.getElementById("password").style.boxShadow = '0px 0px 10px red';
                passwordErrorTag.textContent = "Password must contain one upper case letter";
                passwordErrorTag.classList.add('text-danger');
                return;
            } else if (!(/[a-z]/.test(currentVal))) {
                document.getElementById("password").style.boxShadow = '0px 0px 1px red';
                passwordErrorTag.textContent = "Password must contain one lower case letter";
                passwordErrorTag.classList.add('text-danger');
                return;
            } else if (currentVal.length <= 8) {
                document.getElementById("password").style.boxShadow = '0px 0px 10px orange';
                passwordErrorTag.textContent = "Password must be longer than 8 letter";
                passwordErrorTag.classList.add('text-danger');
                return;
            }
            document.getElementById("password").style.boxShadow = '0px 0px 10px green';
        } else if (event.target.id === 'confirmPassword') {
            if (document.getElementById("password").value.length > 0 && currentVal !== document.getElementById("password").value) {
                document.getElementById("emp-error-field").textContent = "Password do not match";
                return;
            }
        } else if (event.target.id === 'contactNumber') {
            if (currentVal.length < 10) {
                document.getElementById("emp-error-field").textContent = "Invlid phone number";
                return;
            }
        }
        document.getElementById("emp-error-field").textContent = "";
        employeeFormInputDiv[employeeIndex].lastElementChild.removeEventListener("keypress", handleEmpSectInputKeyPress);

        employeeFormInputDiv[employeeIndex].classList.remove('d-flex');
        employeeFormInputDiv[employeeIndex].classList.add('d-none');
        if (employeeIndex == 0) {
            ptag.innerText = `Hi ${employeeFormInputDiv[employeeIndex].lastElementChild.value}, Can i know your gender`
            document.getElementById("genderDiv").classList.remove('d-none');
            document.getElementById("genderDiv").classList.add('d-flex');
            employeeIndex++;
            const radiobtn = document.querySelectorAll("input[name='gender']");
            radiobtn.forEach(btn => btn.addEventListener("click", handleGenderInput));
            return;
        }
        employeeIndex++;
        if (employeeIndex == employeeFormInputDiv.length) {
            document.getElementById("flush-collapseOne").classList.remove("show");
            document.getElementById("flush-collapseTwo").classList.add("show");
            vehicleFormInputDiv[vehicleIndex].classList.remove("d-none");
            vehicleFormInputDiv[vehicleIndex].classList.add("d-flex");
            vehicleFormInputDiv[vehicleIndex].lastElementChild.focus();
            vehicleFormInputDiv[vehicleIndex].lastElementChild.addEventListener("keypress", handleVehcSectInputKeyPress);
            const employeeID = generateEmployeeId();
            ptag.innerHTML = "Employee ID: " + employeeID;
            document.getElementById('vEmpId').value = employeeID;
            alert("Employee ID: " + employeeID);
            return;
        } else {
            employeeFormInputDiv[employeeIndex].classList.remove('d-none');
            employeeFormInputDiv[employeeIndex].classList.add('d-flex');
            employeeFormInputDiv[employeeIndex].lastElementChild.focus();
            employeeFormInputDiv[employeeIndex].lastElementChild.addEventListener("keypress", handleEmpSectInputKeyPress);
        }

    }
}


function handleVehcSectInputKeyPress(event) {
    document.getElementById("veh-error-field").textContent = "";

    const currentVal = event.key.length === 1 ? event.target.value + event.key : event.target.value;

    if (event.key === "Enter") {


        if (event.target.id === 'vName' && currentVal.length < 2) {
            document.getElementById("veh-error-field").textContent = "Vehicle name cannot be this short";
            return;
        }
        else if (event.target.id === 'vType') {
            document.getElementById('vTypeLabel').innerHTML = "Which vehicle do you have";
        }
        else if (event.target.id === 'vNumber' && !(/^[A-Z]{2}\d{2}[A-Z]{2}\d{4}$/i.test(currentVal))) {
            document.getElementById("veh-error-field").textContent = "Invalid Vehicle number";
            return;
        }
        else if (event.target.id === 'vEmpId') {
            if (currentVal.length < 2) {
                document.getElementById("veh-error-field").textContent = "Invalid Employee ID";
                return;
            }
            employeeId = currentVal;
        }




        if (vehicleFormInputDiv[vehicleIndex].lastElementChild.id === 'vType') {
            selectedVehicleType = vehicleFormInputDiv[vehicleIndex].lastElementChild.value;
        }
        vehicleFormInputDiv[vehicleIndex].lastElementChild.removeEventListener("keypress", handleVehcSectInputKeyPress);
        vehicleFormInputDiv[vehicleIndex].classList.remove('d-flex');
        vehicleFormInputDiv[vehicleIndex].classList.add('d-none');
        vehicleIndex++;
        if (vehicleIndex == vehicleFormInputDiv.length) {
            document.getElementById("flush-collapseTwo").classList.remove("show");
            selectedVehicleType = document.getElementById('vType').value;
            rupeePriceList = getRupeePriceList(selectedVehicleType);
            setPricingOfPricingSection(rupeePriceList);
            document.getElementById("price-section").classList.remove('d-none');
            document.getElementById("price-section").classList.add('d-flex');
            document.getElementById('currency-opions').getElementsByTagName('button')[0].classList.remove('btn-secondary');
            document.getElementById('currency-opions').getElementsByTagName('button')[0].classList.add('bg-custom-color');
            currencyType = 'rupee';
            if (selectedVehicleType === 'cycle') {
                document.getElementById("price-section-head").innerHTML += " Cycle"
            }
            else if (selectedVehicleType === 'motorCycle') {
                document.getElementById("price-section-head").innerHTML += " Motor Cycle"
            }
            else if (selectedVehicleType === 'fourWheeler') {
                document.getElementById("price-section-head").innerHTML += " Four Wheeler"
            }
            return;
        } else {
            vehicleFormInputDiv[vehicleIndex].classList.remove('d-none');
            vehicleFormInputDiv[vehicleIndex].classList.add('d-flex');
            vehicleFormInputDiv[vehicleIndex].lastElementChild.focus();
            vehicleFormInputDiv[vehicleIndex].lastElementChild.addEventListener("keypress", handleVehcSectInputKeyPress);
        }
    }
}


function getRupeePriceList(selectedVehicleType) {
    switch (selectedVehicleType) {
        case "cycle":
            return [5, 100, 500];
            break;
        case "motorCycle":
            return [10, 200, 1000];
            break;
        case "fourWheeler":
            return [20, 500, 3500];
            break;
    }
}

function handleVehicleClick(element) {
    // console.log(employeeIndex);
    const currentFocusedInput = employeeFormInputDiv[employeeIndex];
    currentFocusedInput.classList.remove('d-flex');
    currentFocusedInput.classList.add('d-none');
    currentFocusedInput.lastElementChild.removeEventListener("keypress", handleEmpSectInputKeyPress);

    const currentInput = vehicleFormInputDiv[vehicleIndex];
    currentInput.classList.remove('d-none');
    currentInput.classList.add('d-flex');
    currentInput.lastElementChild.addEventListener("keypress", handleVehcSectInputKeyPress);
}

function handleEmployeeClick(element) {
    const currentFocusedInput = vehicleFormInputDiv[vehicleIndex];
    currentFocusedInput.classList.remove('d-flex');
    currentFocusedInput.classList.add('d-none');
    currentFocusedInput.lastElementChild.removeEventListener("keypress", handleVehcSectInputKeyPress);

    const currentInput = employeeFormInputDiv[employeeIndex];
    currentInput.classList.remove('d-none');
    currentInput.classList.add('d-flex');
    currentInput.lastElementChild.addEventListener("keypress", handleEmpSectInputKeyPress);
}

function convertYenToDollar(currency) {
    return (currency / 143).toFixed(3)
}

function convertRupeeTodollar(currency) {
    return (currency / 84).toFixed(3)
}

function handleSelectedCurrency(selectedCurrency) {
    currencyType = selectedCurrency;
    let selectedCurrencyPriceList;
    const currencyList = document.getElementById('currency-opions').getElementsByTagName('button');
    for (const element of currencyList) {
        element.classList.add('btn-secondary')
        element.classList.remove('bg-custom-color')
    }
    document.getElementById(selectedCurrency).classList.remove('btn-secondary');
    document.getElementById(selectedCurrency).classList.add('bg-custom-color');

    switch (selectedCurrency) {
        case 'rupee':
            selectedCurrencyPriceList = rupeePriceList;
            break;
        case 'dollar':
            selectedCurrencyPriceList = rupeePriceList.map(rupeePrice => +(rupeePrice / 83).toFixed(2))
            break;
        case 'yen':
            selectedCurrencyPriceList = rupeePriceList.map(rupeePrice => rupeePrice * 1.73);
            break;
    }
    setPricingOfPricingSection(selectedCurrencyPriceList);
}

function handleSelectedPlan(element) {

    isPlanSelected = true
    const elementsList = document.getElementById("price-list").getElementsByTagName('div');
    for (const element of elementsList) {
        element.classList.remove('bg-custom-color');
    }
    element.classList.add('bg-custom-color');
    selectedPlan = element.id;
    planDuration = element.getElementsByTagName('div')[0].firstElementChild.innerHTML;
    planPrice = element.getElementsByTagName('div')[0].lastElementChild.innerHTML;

    if (currencyType == 'rupee') {
        selectedPlan = convertRupeeTodollar(planPrice);
    }
    else if (currencyType == 'yen') {
        selectedPlan = convertYenToDollar(planPrice)
    } else {
        selectedPlan = planPrice;
    }
}


function generatePass() {
    if (!isPlanSelected) {
        alert("Please Select a plan");
        return;
    }
    else {
        document.getElementById('pass-emp-id').textContent += employeeId;
        document.getElementById('pass-veh-num').textContent += document.getElementById('vNumber').value;
        document.getElementById('pass-sel-plan').textContent += selectedPlan + "$" + " ( " + planDuration + " )";
        document.getElementById('generatePassBtn').classList.add('d-none');
        document.querySelector('.pass-generated-section').classList.remove('d-none');
        document.querySelector('.pass-generated-section').classList.add('d-flex');
    }
}