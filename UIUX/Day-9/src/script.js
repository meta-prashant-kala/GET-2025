"use strict";
var _a;
let employeeIndex = 0;
let vehicleIndex = 0;
let employeeId;
let selectedVehicleType;
let rupeePriceList;
let selectedPlan;
const ptag = document.getElementById("person-name");
(_a = document.getElementById('accordion-item-1')) === null || _a === void 0 ? void 0 : _a.getElementsByTagName('div')[employeeIndex].classList.add('show');
const employeeForm = document.getElementById("employee-form");
const employeeFormInputDiv = employeeForm === null || employeeForm === void 0 ? void 0 : employeeForm.getElementsByTagName("div");
if (employeeFormInputDiv) {
    employeeFormInputDiv[employeeIndex].classList.remove('d-none');
    employeeFormInputDiv[employeeIndex].classList.add('d-flex');
    const lastElementChild = employeeFormInputDiv[employeeIndex].lastElementChild;
    lastElementChild.focus();
}
const vehicleForm = document.getElementById("vehicle-form");
const vehicleFormInputDiv = vehicleForm === null || vehicleForm === void 0 ? void 0 : vehicleForm.getElementsByTagName("div");
const generateEmployeeId = () => {
    var _a;
    const formDivList = (_a = document.getElementById("employee-form")) === null || _a === void 0 ? void 0 : _a.getElementsByTagName('div');
    const vEmpId = document.getElementById('vEmpId');
    employeeId = (vEmpId === null || vEmpId === void 0 ? void 0 : vEmpId.value) + Math.floor(Math.random() * 1000);
    return employeeId;
};
const handleGenderInput = (event) => {
    var _a, _b;
    (_a = document.getElementById('genderDiv')) === null || _a === void 0 ? void 0 : _a.classList.remove("d-flex");
    (_b = document.getElementById('genderDiv')) === null || _b === void 0 ? void 0 : _b.classList.add("d-none");
    employeeIndex += 3;
    if (employeeFormInputDiv) {
        const currentEmployeeFormInputDiv = employeeFormInputDiv[employeeIndex];
        currentEmployeeFormInputDiv === null || currentEmployeeFormInputDiv === void 0 ? void 0 : currentEmployeeFormInputDiv.classList.remove('d-none');
        currentEmployeeFormInputDiv === null || currentEmployeeFormInputDiv === void 0 ? void 0 : currentEmployeeFormInputDiv.classList.add('d-flex');
        const currentEmployeeFormInputDivLastChild = currentEmployeeFormInputDiv === null || currentEmployeeFormInputDiv === void 0 ? void 0 : currentEmployeeFormInputDiv.lastElementChild;
        currentEmployeeFormInputDivLastChild === null || currentEmployeeFormInputDivLastChild === void 0 ? void 0 : currentEmployeeFormInputDivLastChild.focus();
        currentEmployeeFormInputDivLastChild === null || currentEmployeeFormInputDivLastChild === void 0 ? void 0 : currentEmployeeFormInputDivLastChild.addEventListener("keypress", handleEmpSectInputKeyPress);
        employeeFormInputDiv[0].setAttribute('style', 'display:none !important');
        if (ptag) {
            ptag.innerText = "";
        }
    }
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
    return [];
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
        currentInput === null || currentInput === void 0 ? void 0 : currentInput.classList.remove('d-none');
        currentInput === null || currentInput === void 0 ? void 0 : currentInput.classList.add('d-flex');
        (currentInput === null || currentInput === void 0 ? void 0 : currentInput.lastElementChild).addEventListener("keypress", handleVehcSectInputKeyPress);
    }
};
const handleEmployeeClick = (element) => {
    if (vehicleFormInputDiv) {
        const currentFocusedInput = vehicleFormInputDiv[employeeIndex];
        currentFocusedInput.classList.remove('d-flex');
        currentFocusedInput.classList.add('d-none');
        currentFocusedInput.lastElementChild.removeEventListener("keypress", handleVehcSectInputKeyPress);
    }
    if (employeeFormInputDiv) {
        const currentInput = employeeFormInputDiv[vehicleIndex];
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
    setPricingOfPricingSection(selectedCurrencyPriceList);
};
const handleSelectedPlan = (element) => {
    var _a, _b, _c;
    const elementsList = (_a = document.getElementById("price-list")) === null || _a === void 0 ? void 0 : _a.getElementsByTagName('div');
    if (elementsList) {
        for (const element of elementsList) {
            element.classList.remove('bg-custom-color');
        }
    }
    element.classList.add('bg-custom-color');
    selectedPlan = ((_c = (_b = element.firstElementChild) === null || _b === void 0 ? void 0 : _b.lastElementChild) === null || _c === void 0 ? void 0 : _c.innerHTML) || "";
};
const generatePass = () => {
    const employeeFormData = document.getElementById("employee-form");
    const vehicleFormData = document.getElementById("vehicle-form");
    console.log(employeeForm);
    console.log(vehicleForm);
    alert("Congratualtion !! Your pass has been genrated\n" + "Employee ID: " + employeeId + "\nSelected Plan: " + selectedPlan);
};
const handleVehcSectInputKeyPress = (event) => {
    var _a, _b, _c, _d, _e;
    document.getElementById("veh-error-field").textContent = "";
    const target = event.target;
    const currentVal = event.key.length === 1 ? target.value + event.key : target.value;
    if (target.id === 'vName' && currentVal.length < 2) {
        document.getElementById("veh-error-field").textContent = "Vehicle name cannot be this short";
        return;
    }
    else if (target.id === 'vType') {
        document.getElementById('vTypeLabel').innerHTML = "Which vehicle do you have";
    }
    else if (target.id === 'vNumber' && !(/^[A-Z]{2}\d{2}[A-Z]{2}\d{4}$/i.test(currentVal))) {
        document.getElementById("veh-error-field").textContent = "Invalid Vehicle number";
        return;
    }
    else if (target.id === 'vEmpId') {
        employeeId = currentVal;
    }
    if (event.key === "Enter") {
        if (vehicleFormInputDiv && vehicleFormInputDiv[vehicleIndex].lastElementChild.id === 'vType') {
            selectedVehicleType = vehicleFormInputDiv[vehicleIndex].lastElementChild.value;
        }
        if (vehicleFormInputDiv) {
            vehicleFormInputDiv[vehicleIndex].lastElementChild.removeEventListener("keypress", handleVehcSectInputKeyPress);
            vehicleFormInputDiv[vehicleIndex].classList.remove('d-flex');
            vehicleFormInputDiv[vehicleIndex].classList.add('d-none');
        }
        vehicleIndex++;
        if (vehicleIndex == (vehicleFormInputDiv === null || vehicleFormInputDiv === void 0 ? void 0 : vehicleFormInputDiv.length)) {
            (_a = document.getElementById("flush-collapseTwo")) === null || _a === void 0 ? void 0 : _a.classList.remove("show");
            selectedVehicleType = document.getElementById('vType').value;
            rupeePriceList = getRupeePriceList(selectedVehicleType);
            setPricingOfPricingSection(rupeePriceList);
            (_b = document.getElementById("price-section")) === null || _b === void 0 ? void 0 : _b.classList.remove('d-none');
            (_c = document.getElementById("price-section")) === null || _c === void 0 ? void 0 : _c.classList.add('d-flex');
            (_d = document.getElementById('currency-opions')) === null || _d === void 0 ? void 0 : _d.getElementsByTagName('button')[0].classList.remove('btn-secondary');
            (_e = document.getElementById('currency-opions')) === null || _e === void 0 ? void 0 : _e.getElementsByTagName('button')[0].classList.add('bg-custom-color');
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
    const target = event.target;
    const currentVal = event.key.length === 1 ? target.value + event.key : target.value;
    console.log(currentVal);
    if (target.id === 'fullName' && currentVal.length <= 2) {
        document.getElementById("emp-error-field").textContent = "Name cannot be this short";
        return;
    }
    else if (target.id === 'email' && !(/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(currentVal))) {
        document.getElementById("emp-error-field").textContent = "Invalid email";
        return;
    }
    else if (target.id === 'password') {
        const passwordErrorTag = document.getElementById('emp-error-field');
        const passwordInputTag = document.getElementById("password");
        if (!(/[A-Z]/.test(currentVal))) {
            passwordInputTag.style.boxShadow = '0px 0px 10px red';
            passwordErrorTag.textContent = "Password must contain one upper case letter";
            passwordErrorTag.classList.add('text-danger');
            return;
        }
        else if (!(/[a-z]/.test(currentVal))) {
            passwordInputTag.style.boxShadow = '0px 0px 1px red';
            passwordErrorTag.textContent = "Password must contain one lower case letter";
            passwordErrorTag.classList.add('text-danger');
            return;
        }
        else if (currentVal.length <= 8) {
            passwordInputTag.style.boxShadow = '0px 0px 10px orange';
            passwordErrorTag.textContent = "Password must be longer than 8 letter";
            passwordErrorTag.classList.add('text-danger');
            return;
        }
        document.getElementById("password").style.boxShadow = '0px 0px 10px green';
    }
    else if (target.id === 'confirmPassword') {
        if (document.getElementById("password").value.length > 0 && currentVal !== document.getElementById("password").value) {
            document.getElementById("emp-error-field").textContent = "Password do not match";
            return;
        }
    }
    else if (target.id === 'contactNumber') {
        if (currentVal.length < 10) {
            document.getElementById("emp-error-field").textContent = "Invlid phone number";
            return;
        }
    }
    if (event.key === "Enter") {
        document.getElementById("emp-error-field").textContent = "";
        if (employeeFormInputDiv) {
            employeeFormInputDiv[employeeIndex].lastElementChild.removeEventListener("keypress", handleEmpSectInputKeyPress);
            employeeFormInputDiv[employeeIndex].classList.remove('d-flex');
            employeeFormInputDiv[employeeIndex].classList.add('d-none');
        }
        if (employeeIndex === 0 && employeeFormInputDiv) {
            const currEmployeeFormInputDiv = employeeFormInputDiv[employeeIndex];
            if (ptag && currEmployeeFormInputDiv) {
                ptag.innerText = `Hi ${currEmployeeFormInputDiv.lastElementChild.value}, Can i know your gender`;
            }
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
            ptag && (ptag.innerHTML = "Employee ID: " + employeeID);
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
employeeFormInputDiv && employeeFormInputDiv[employeeIndex].lastElementChild.addEventListener("keypress", handleEmpSectInputKeyPress);
