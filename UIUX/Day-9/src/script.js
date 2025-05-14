"use strict";
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
class EmpVehPass {
    constructor() {
        this.selectedPlan = "";
        this.planType = "";
        this.empId = "";
        this.empName = "";
        this.empGender = "";
        this.empEmail = "";
        this.empPassword = "";
        this.empNumber = "";
        this.vehName = "";
        this.vehType = "";
        this.vehNumber = "";
        this.vehIdentification = "";
    }
}
const empVehPassData = {};
document.getElementById('accordion-item-1').getElementsByTagName('div')[employeeIndex].classList.add('show');
const employeeForm = document.getElementById("employee-form");
const employeeFormInputDiv = employeeForm === null || employeeForm === void 0 ? void 0 : employeeForm.getElementsByTagName("div");
if (employeeFormInputDiv) {
    employeeFormInputDiv[employeeIndex].classList.remove('d-none');
    employeeFormInputDiv[employeeIndex].classList.add('d-flex');
    employeeFormInputDiv[employeeIndex].lastElementChild.focus();
}
const vehicleForm = document.getElementById("vehicle-form");
const vehicleFormInputDiv = vehicleForm === null || vehicleForm === void 0 ? void 0 : vehicleForm.getElementsByTagName("div");
const generateEmployeeId = () => {
    const formDivList = document.getElementById("employee-form").getElementsByTagName('div');
    employeeId = document.getElementById('vEmpId').value + Math.floor(Math.random() * 1000);
    return empVehPassData.empId = employeeId;
};
const convertYenToDollar = (currency) => {
    return (currency / 143).toFixed(3);
};
const convertRupeeTodollar = (currency) => {
    return (currency / 84).toFixed(3);
};
const handleGenderInput = (event) => {
    empVehPassData.empGender = event.target.value;
    document.getElementById('genderDiv').classList.remove("d-flex");
    document.getElementById('genderDiv').classList.add("d-none");
    employeeIndex += 3;
    if (employeeFormInputDiv) {
        employeeFormInputDiv[employeeIndex].classList.remove('d-none');
        employeeFormInputDiv[employeeIndex].classList.add('d-flex');
        employeeFormInputDiv[employeeIndex].lastElementChild.focus();
        employeeFormInputDiv[employeeIndex].lastElementChild.addEventListener("keypress", handleEmpSectInputKeyPress);
        employeeFormInputDiv[0].setAttribute('style', 'display:none !important');
    }
    ptag && (ptag.innerText = "");
};
const setPricingOfPricingSection = (priceList) => {
    document.getElementById("per-day-price").innerHTML = priceList[0].toString();
    document.getElementById("per-month-price").innerHTML = priceList[1].toString();
    document.getElementById("per-year-price").innerHTML = priceList[2].toString();
};
const getRupeePriceList = (selectedVehicleType) => {
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
};
const handleVehicleClick = (element) => {
    if (employeeFormInputDiv) {
        const currentFocusedInput = employeeFormInputDiv[employeeIndex];
        currentFocusedInput.classList.remove('d-flex');
        currentFocusedInput.classList.add('d-none');
        currentFocusedInput.lastElementChild.removeEventListener("keypress", handleEmpSectInputKeyPress);
    }
    if (vehicleFormInputDiv) {
        const currentInput = vehicleFormInputDiv[vehicleIndex];
        currentInput.classList.remove('d-none');
        currentInput.classList.add('d-flex');
        currentInput.lastElementChild.addEventListener("keypress", handleVehcSectInputKeyPress);
    }
};
const handleEmployeeClick = (element) => {
    if (vehicleFormInputDiv) {
        const currentFocusedInput = vehicleFormInputDiv[vehicleIndex];
        currentFocusedInput.classList.remove('d-flex');
        currentFocusedInput.classList.add('d-none');
        currentFocusedInput.lastElementChild.removeEventListener("keypress", handleVehcSectInputKeyPress);
    }
    if (employeeFormInputDiv) {
        const currentInput = employeeFormInputDiv[employeeIndex];
        currentInput.classList.remove('d-none');
        currentInput.classList.add('d-flex');
        currentInput.lastElementChild.addEventListener("keypress", handleEmpSectInputKeyPress);
    }
};
const handleSelectedCurrency = (selectedCurrency) => {
    var _a, _b, _c;
    let selectedCurrencyPriceList;
    const currencyList = (_a = document.getElementById('currency-opions')) === null || _a === void 0 ? void 0 : _a.getElementsByTagName('button');
    if (currencyList) {
        for (const element of currencyList) {
            element.classList.add('btn-secondary');
            element.classList.remove('bg-custom-color');
        }
    }
    (_b = document.getElementById(selectedCurrency)) === null || _b === void 0 ? void 0 : _b.classList.remove('btn-secondary');
    (_c = document.getElementById(selectedCurrency)) === null || _c === void 0 ? void 0 : _c.classList.add('bg-custom-color');
    switch (selectedCurrency) {
        case 'rupee':
            selectedCurrencyPriceList = rupeePriceList;
            break;
        case 'dollar':
            console.log(rupeePriceList);
            selectedCurrencyPriceList = rupeePriceList.map(rupeePrice => +(rupeePrice / 83).toFixed(2));
            break;
        case 'yen':
            selectedCurrencyPriceList = rupeePriceList.map(rupeePrice => rupeePrice * 1.73);
            break;
    }
    selectedCurrencyPriceList && setPricingOfPricingSection(selectedCurrencyPriceList);
};
const handleSelectedPlan = (element) => {
    var _a;
    isPlanSelected = true;
    const elementsList = (_a = document.getElementById("price-list")) === null || _a === void 0 ? void 0 : _a.getElementsByTagName('div');
    if (elementsList) {
        for (const element of elementsList) {
            element.classList.remove('bg-custom-color');
        }
        element.classList.add('bg-custom-color');
    }
    selectedPlan = Number(element.id);
    planDuration = element.getElementsByTagName('div')[0].firstElementChild.innerHTML;
    const planPrice = Number(element.getElementsByTagName('div')[0].lastElementChild.innerHTML);
    if (currencyType == 'rupee') {
        selectedPlan = Number(convertRupeeTodollar(planPrice));
    }
    else if (currencyType == 'yen') {
        selectedPlan = Number(convertYenToDollar(planPrice));
    }
    else {
        selectedPlan = planPrice;
    }
};
const generatePass = () => {
    var _a, _b, _c, _d, _e;
    if (!isPlanSelected) {
        alert("Please Select a plan");
        return;
    }
    else {
        empVehPassData.empName = document.getElementById('fullName').value;
        empVehPassData.empEmail = document.getElementById('email').value;
        empVehPassData.empNumber = document.getElementById('contactNumber').value;
        empVehPassData.vehName = (_a = document.getElementById('vName').value) !== null && _a !== void 0 ? _a : "";
        empVehPassData.vehType = (_b = document.getElementById('vType').value) !== null && _b !== void 0 ? _b : "";
        empVehPassData.vehNumber = (_c = document.getElementById('vNumber').value) !== null && _c !== void 0 ? _c : "";
        empVehPassData.vehIdentification = (_d = document.getElementById('identification').value) !== null && _d !== void 0 ? _d : "";
        document.getElementById('pass-emp-id').textContent += (_e = empVehPassData.empId) !== null && _e !== void 0 ? _e : "";
        document.getElementById('pass-veh-num').textContent += empVehPassData.vehNumber;
        document.getElementById('pass-sel-plan').textContent += selectedPlan + "$" + " ( " + planDuration + " )";
        document.getElementById('generatePassBtn').classList.add('d-none');
        document.querySelector('.pass-generated-section').classList.remove('d-none');
        document.querySelector('.pass-generated-section').classList.add('d-flex');
        localStorage.setItem("EmpVehPass", JSON.stringify(empVehPassData));
    }
};
const handleVehcSectInputKeyPress = (event) => {
    var _a;
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
        if (vehicleFormInputDiv && vehicleFormInputDiv[vehicleIndex].lastElementChild.id === 'vType') {
            selectedVehicleType = vehicleFormInputDiv[vehicleIndex].lastElementChild.value;
        }
        if (vehicleFormInputDiv) {
            vehicleFormInputDiv[vehicleIndex].lastElementChild.removeEventListener("keypress", handleVehcSectInputKeyPress);
            vehicleFormInputDiv[vehicleIndex].classList.remove('d-flex');
            vehicleFormInputDiv[vehicleIndex].classList.add('d-none');
        }
        vehicleIndex++;
        if (vehicleFormInputDiv && vehicleIndex == vehicleFormInputDiv.length) {
            document.getElementById("flush-collapseTwo").classList.remove("show");
            selectedVehicleType = document.getElementById('vType').value;
            rupeePriceList = (_a = getRupeePriceList(selectedVehicleType)) !== null && _a !== void 0 ? _a : [];
            setPricingOfPricingSection(rupeePriceList);
            document.getElementById("price-section").classList.remove('d-none');
            document.getElementById("price-section").classList.add('d-flex');
            document.getElementById('currency-opions').getElementsByTagName('button')[0].classList.remove('btn-secondary');
            document.getElementById('currency-opions').getElementsByTagName('button')[0].classList.add('bg-custom-color');
            currencyType = 'rupee';
            if (selectedVehicleType === 'cycle') {
                document.getElementById("price-section-head").innerHTML += " Cycle";
            }
            else if (selectedVehicleType === 'motorCycle') {
                document.getElementById("price-section-head").innerHTML += " Motor Cycle";
            }
            else if (selectedVehicleType === 'fourWheeler') {
                document.getElementById("price-section-head").innerHTML += " Four Wheeler";
            }
            return;
        }
        else {
            if (vehicleFormInputDiv) {
                vehicleFormInputDiv[vehicleIndex].classList.remove('d-none');
                vehicleFormInputDiv[vehicleIndex].classList.add('d-flex');
                vehicleFormInputDiv[vehicleIndex].lastElementChild.focus();
                vehicleFormInputDiv[vehicleIndex].lastElementChild.addEventListener("keypress", handleVehcSectInputKeyPress);
            }
        }
    }
};
const handleEmpSectInputKeyPress = (event) => {
    var _a, _b, _c, _d;
    document.getElementById("emp-error-field").textContent = "";
    const currentVal = event.key.length === 1 ? event.target.value + event.key : event.target.value;
    if (event.key === "Enter") {
        if (event.target.id === 'fullName' && currentVal.length <= 2) {
            document.getElementById("emp-error-field").textContent = "Name cannot be this short";
            return;
        }
        else if (event.target.id === 'email' && !(/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(currentVal))) {
            document.getElementById("emp-error-field").textContent = "Invalid email";
            return;
        }
        else if (event.target.id === 'password') {
            const passwordErrorTag = document.getElementById('emp-error-field');
            if (!(/[A-Z]/.test(currentVal))) {
                document.getElementById("password").style.boxShadow = '0px 0px 10px red';
                passwordErrorTag.textContent = "Password must contain one upper case letter";
                passwordErrorTag.classList.add('text-danger');
                return;
            }
            else if (!(/[a-z]/.test(currentVal))) {
                document.getElementById("password").style.boxShadow = '0px 0px 1px red';
                passwordErrorTag.textContent = "Password must contain one lower case letter";
                passwordErrorTag.classList.add('text-danger');
                return;
            }
            else if (currentVal.length <= 8) {
                document.getElementById("password").style.boxShadow = '0px 0px 10px orange';
                passwordErrorTag.textContent = "Password must be longer than 8 letter";
                passwordErrorTag.classList.add('text-danger');
                return;
            }
            document.getElementById("password").style.boxShadow = '0px 0px 10px green';
        }
        else if (event.target.id === 'confirmPassword') {
            if (document.getElementById("password").value.length > 0 && currentVal !== document.getElementById("password").value) {
                document.getElementById("emp-error-field").textContent = "Password do not match";
                return;
            }
        }
        else if (event.target.id === 'contactNumber') {
            if (currentVal.length < 10) {
                document.getElementById("emp-error-field").textContent = "Invlid phone number";
                return;
            }
        }
        document.getElementById("emp-error-field").textContent = "";
        if (employeeFormInputDiv) {
            employeeFormInputDiv[employeeIndex].lastElementChild.removeEventListener("keypress", handleEmpSectInputKeyPress);
            employeeFormInputDiv[employeeIndex].classList.remove('d-flex');
            employeeFormInputDiv[employeeIndex].classList.add('d-none');
        }
        if (employeeIndex == 0) {
            ptag.innerText = `Hi ${(employeeFormInputDiv && employeeFormInputDiv[employeeIndex].lastElementChild.value)}, Can i know your gender`;
            (_a = document.getElementById("genderDiv")) === null || _a === void 0 ? void 0 : _a.classList.remove('d-none');
            (_b = document.getElementById("genderDiv")) === null || _b === void 0 ? void 0 : _b.classList.add('d-flex');
            const radiobtn = document.querySelectorAll("input[name='gender']");
            radiobtn.forEach(btn => btn.addEventListener("click", handleGenderInput));
            return;
        }
        employeeIndex++;
        if (employeeFormInputDiv && employeeIndex == employeeFormInputDiv.length) {
            (_c = document.getElementById("flush-collapseOne")) === null || _c === void 0 ? void 0 : _c.classList.remove("show");
            (_d = document.getElementById("flush-collapseTwo")) === null || _d === void 0 ? void 0 : _d.classList.add("show");
            if (vehicleFormInputDiv) {
                vehicleFormInputDiv[vehicleIndex].classList.remove("d-none");
                vehicleFormInputDiv[vehicleIndex].classList.add("d-flex");
                vehicleFormInputDiv[vehicleIndex].lastElementChild.focus();
                vehicleFormInputDiv[vehicleIndex].lastElementChild.addEventListener("keypress", handleVehcSectInputKeyPress);
            }
            const employeeID = generateEmployeeId();
            ptag.innerHTML = "Employee ID: " + employeeID;
            document.getElementById('vEmpId').value = employeeID;
            alert("Employee ID: " + employeeID);
            return;
        }
        else {
            if (employeeFormInputDiv) {
                employeeFormInputDiv[employeeIndex].classList.remove('d-none');
                employeeFormInputDiv[employeeIndex].classList.add('d-flex');
                employeeFormInputDiv[employeeIndex].lastElementChild.focus();
                employeeFormInputDiv[employeeIndex].lastElementChild.addEventListener("keypress", handleEmpSectInputKeyPress);
            }
        }
    }
};
if (employeeFormInputDiv) {
    employeeFormInputDiv[employeeIndex].lastElementChild.addEventListener("keypress", handleEmpSectInputKeyPress);
}
