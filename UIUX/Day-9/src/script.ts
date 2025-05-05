let employeeIndex = 0;
let vehicleIndex = 0;
let employeeId : string;
let selectedVehicleType : string;
let rupeePriceList : number[];
let selectedPlan : string;
const ptag = document.getElementById("person-name");

document.getElementById('accordion-item-1')?.getElementsByTagName('div')[employeeIndex].classList.add('show');
const employeeForm = document.getElementById("employee-form");
const employeeFormInputDiv = employeeForm?.getElementsByTagName("div");

if (employeeFormInputDiv) {
    employeeFormInputDiv[employeeIndex].classList.remove('d-none');
    employeeFormInputDiv[employeeIndex].classList.add('d-flex');
    const lastElementChild = employeeFormInputDiv[employeeIndex].lastElementChild as HTMLInputElement
    lastElementChild.focus();
}


const vehicleForm = document.getElementById("vehicle-form");
const vehicleFormInputDiv = vehicleForm?.getElementsByTagName("div");

const generateEmployeeId = () => {
    const formDivList = document.getElementById("employee-form")?.getElementsByTagName('div');
    const vEmpId = document.getElementById('vEmpId') as HTMLInputElement;
    employeeId = vEmpId?.value + Math.floor(Math.random() * 1000);
    return employeeId;
}


const handleGenderInput = (event: Event) => {
    document.getElementById('genderDiv')?.classList.remove("d-flex");
    document.getElementById('genderDiv')?.classList.add("d-none");
    employeeIndex += 3;
    if (employeeFormInputDiv) {
        const currentEmployeeFormInputDiv = employeeFormInputDiv[employeeIndex] as HTMLInputElement;
        currentEmployeeFormInputDiv?.classList.remove('d-none');
        currentEmployeeFormInputDiv?.classList.add('d-flex');
        const currentEmployeeFormInputDivLastChild = currentEmployeeFormInputDiv?.lastElementChild as HTMLInputElement;
        currentEmployeeFormInputDivLastChild?.focus();
        currentEmployeeFormInputDivLastChild?.addEventListener("keypress", handleEmpSectInputKeyPress);
        employeeFormInputDiv[0].setAttribute('style', 'display:none !important');
        if (ptag) {
            ptag.innerText = "";
        }
    }
}

const setPricingOfPricingSection = (priceList: number[]) => {
    (document.getElementById("per-day-price") as HTMLSpanElement).innerHTML = priceList[0].toString();
    (document.getElementById("per-month-price") as HTMLSpanElement).innerHTML = priceList[1].toString();
    (document.getElementById("per-year-price") as HTMLSpanElement).innerHTML = priceList[2].toString();
}

const getRupeePriceList = (selectedVehicleType: string) => {
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
    return []
}

const handleVehicleClick = (element: HTMLElement) => {
    if (employeeFormInputDiv) {
        const currentFocusedInput = employeeFormInputDiv[employeeIndex]
        currentFocusedInput.classList.remove('d-flex');
        currentFocusedInput.classList.add('d-none');
        (currentFocusedInput.lastElementChild as HTMLInputElement).removeEventListener("keypress", handleEmpSectInputKeyPress);
    }

    if (vehicleFormInputDiv) {
        const currentInput = vehicleFormInputDiv[vehicleIndex]
        currentInput?.classList.remove('d-none');
        currentInput?.classList.add('d-flex');
        (currentInput?.lastElementChild as HTMLInputElement).addEventListener("keypress", handleVehcSectInputKeyPress);
    }
}

const handleEmployeeClick = (element: HTMLElement) => {
    if (vehicleFormInputDiv) {
        const currentFocusedInput = vehicleFormInputDiv[employeeIndex];
        currentFocusedInput.classList.remove('d-flex');
        currentFocusedInput.classList.add('d-none');
        (currentFocusedInput.lastElementChild as HTMLInputElement).removeEventListener("keypress", handleVehcSectInputKeyPress);
    }

    if (employeeFormInputDiv) {
        const currentInput = employeeFormInputDiv[vehicleIndex];
        currentInput.classList.remove('d-none');
        currentInput.classList.add('d-flex');
        (currentInput.lastElementChild as HTMLInputElement).addEventListener("keypress", handleEmpSectInputKeyPress);
    }
}

const handleSelectedCurrency = (selectedCurrency: string) => {
    let selectedCurrencyPriceList;
    const currencyList = document.getElementById('currency-opions')?.getElementsByTagName('button');
    if (currencyList) {
        for (const element of currencyList) {
            element.classList.add('btn-secondary')
            element.classList.remove('bg-custom-color')
        }
    }
    document.getElementById(selectedCurrency)?.classList.remove('btn-secondary');
    document.getElementById(selectedCurrency)?.classList.add('bg-custom-color');
    switch (selectedCurrency) {
        case 'rupee':
            selectedCurrencyPriceList = rupeePriceList;
            break;
        case 'dollar':
            console.log(rupeePriceList);
            selectedCurrencyPriceList = rupeePriceList.map(rupeePrice => +(rupeePrice / 83).toFixed(2))
            break;
        case 'yen':
            selectedCurrencyPriceList = rupeePriceList.map(rupeePrice => rupeePrice * 1.73);
            break;
    }
    setPricingOfPricingSection(selectedCurrencyPriceList);
}

const handleSelectedPlan = (element: HTMLElement) => {
    const elementsList = document.getElementById("price-list")?.getElementsByTagName('div');
    if (elementsList) {
        for (const element of elementsList) {
            element.classList.remove('bg-custom-color');
        }
    }
    element.classList.add('bg-custom-color');
    selectedPlan = element.firstElementChild?.lastElementChild?.innerHTML || "";
}


const generatePass = () => {
    const employeeFormData=document.getElementById("employee-form");
    const vehicleFormData=document.getElementById("vehicle-form");
    console.log(employeeForm);
    console.log(vehicleForm);
    alert("Congratualtion !! Your pass has been genrated\n" + "Employee ID: " + employeeId + "\nSelected Plan: " + selectedPlan);
}


const handleVehcSectInputKeyPress = (event: KeyboardEvent) => {

    (document.getElementById("veh-error-field") as HTMLParagraphElement).textContent = "";
    const target = event.target as HTMLInputElement;

    const currentVal = event.key.length === 1 ? target.value + event.key : target.value;

    if (target.id === 'vName' && currentVal.length < 2) {
        (document.getElementById("veh-error-field") as HTMLParagraphElement).textContent = "Vehicle name cannot be this short";
        return;
    }
    else if (target.id === 'vType') {
        (document.getElementById('vTypeLabel') as HTMLParagraphElement).innerHTML = "Which vehicle do you have";
    }
    else if (target.id === 'vNumber' && !(/^[A-Z]{2}\d{2}[A-Z]{2}\d{4}$/i.test(currentVal))) {
        (document.getElementById("veh-error-field") as HTMLParagraphElement).textContent = "Invalid Vehicle number";
        return;
    }
    else if (target.id === 'vEmpId') {
        employeeId = currentVal;
    }

    if (event.key === "Enter") {
        if (vehicleFormInputDiv && (vehicleFormInputDiv[vehicleIndex].lastElementChild as HTMLInputElement).id === 'vType') {
            selectedVehicleType = (vehicleFormInputDiv[vehicleIndex].lastElementChild as HTMLInputElement).value;
        }
        if (vehicleFormInputDiv) {
            (vehicleFormInputDiv[vehicleIndex].lastElementChild as HTMLInputElement).removeEventListener("keypress", handleVehcSectInputKeyPress);
            vehicleFormInputDiv[vehicleIndex].classList.remove('d-flex');
            vehicleFormInputDiv[vehicleIndex].classList.add('d-none');
        }
        vehicleIndex++;
        if (vehicleIndex == vehicleFormInputDiv?.length) {
            document.getElementById("flush-collapseTwo")?.classList.remove("show");
            selectedVehicleType = (document.getElementById('vType') as HTMLSelectElement).value;
            rupeePriceList = getRupeePriceList(selectedVehicleType);
            setPricingOfPricingSection(rupeePriceList);
            document.getElementById("price-section")?.classList.remove('d-none');
            document.getElementById("price-section")?.classList.add('d-flex');
            document.getElementById('currency-opions')?.getElementsByTagName('button')[0].classList.remove('btn-secondary');
            document.getElementById('currency-opions')?.getElementsByTagName('button')[0].classList.add('bg-custom-color');

            if (selectedVehicleType === 'cycle') {
                (document.getElementById("price-section-head") as HTMLHeadingElement).innerHTML += " Cycle"
            }
            else if (selectedVehicleType === 'motorCycle') {
                (document.getElementById("price-section-head") as HTMLHeadingElement).innerHTML += " Motor Cycle"
            }
            else if (selectedVehicleType === 'fourWheeler') {
                (document.getElementById("price-section-head") as HTMLHeadingElement).innerHTML += " Four Wheeler"
            }
            return;
        } else {
            if (vehicleFormInputDiv) {
                vehicleFormInputDiv[vehicleIndex].classList.remove('d-none');
                vehicleFormInputDiv[vehicleIndex].classList.add('d-flex');
                (vehicleFormInputDiv[vehicleIndex].lastElementChild as HTMLInputElement).focus();
                (vehicleFormInputDiv[vehicleIndex].lastElementChild as HTMLInputElement).addEventListener("keypress", handleVehcSectInputKeyPress);
            }
        }
    }
}


const handleEmpSectInputKeyPress = (event: KeyboardEvent) => {
    (document.getElementById("emp-error-field") as HTMLParagraphElement).textContent = "";
    const target = event.target as HTMLInputElement;

    const currentVal = event.key.length === 1 ? target.value + event.key : target.value;
    console.log(currentVal);

    if (target.id === 'fullName' && currentVal.length <= 2) {
        (document.getElementById("emp-error-field") as HTMLParagraphElement).textContent = "Name cannot be this short";
        return;
    } else if (target.id === 'email' && !(/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(currentVal))) {
        (document.getElementById("emp-error-field") as HTMLParagraphElement).textContent = "Invalid email";
        return;
    } else if (target.id === 'password') {
        const passwordErrorTag = document.getElementById('emp-error-field') as HTMLParagraphElement;
        const passwordInputTag = document.getElementById("password") as HTMLInputElement;
        if (!(/[A-Z]/.test(currentVal))) {
            passwordInputTag.style.boxShadow = '0px 0px 10px red';
            passwordErrorTag.textContent = "Password must contain one upper case letter";
            passwordErrorTag.classList.add('text-danger');
            return;
        } else if (!(/[a-z]/.test(currentVal))) {
            passwordInputTag.style.boxShadow = '0px 0px 1px red';
            passwordErrorTag.textContent = "Password must contain one lower case letter";
            passwordErrorTag.classList.add('text-danger');
            return;
        } else if (currentVal.length <= 8) {
            passwordInputTag.style.boxShadow = '0px 0px 10px orange';
            passwordErrorTag.textContent = "Password must be longer than 8 letter";
            passwordErrorTag.classList.add('text-danger');
            return;
        }
        (document.getElementById("password") as HTMLInputElement).style.boxShadow = '0px 0px 10px green';
    } else if (target.id === 'confirmPassword') {
        if ((document.getElementById("password") as HTMLInputElement).value.length > 0 && currentVal !== (document.getElementById("password") as HTMLInputElement).value) {
            (document.getElementById("emp-error-field") as HTMLInputElement).textContent = "Password do not match";
            return;
        }
    } else if (target.id === 'contactNumber') {
        if (currentVal.length < 10) {
            (document.getElementById("emp-error-field") as HTMLParagraphElement).textContent = "Invlid phone number";
            return;
        }
    }

    if (event.key === "Enter") {
        (document.getElementById("emp-error-field") as HTMLParagraphElement).textContent = "";
        if (employeeFormInputDiv) {
            (employeeFormInputDiv[employeeIndex].lastElementChild as HTMLParagraphElement).removeEventListener("keypress", handleEmpSectInputKeyPress);
            employeeFormInputDiv[employeeIndex].classList.remove('d-flex');
            employeeFormInputDiv[employeeIndex].classList.add('d-none');
        }
        if (employeeIndex === 0 && employeeFormInputDiv) {
            const currEmployeeFormInputDiv = employeeFormInputDiv[employeeIndex] as HTMLDivElement;
            if (ptag && currEmployeeFormInputDiv) {
                ptag.innerText = `Hi ${(currEmployeeFormInputDiv.lastElementChild as HTMLInputElement).value}, Can i know your gender`

            }
            document.getElementById("genderDiv")?.classList.remove('d-none');
            document.getElementById("genderDiv")?.classList.add('d-flex');
            const radiobtn = document.querySelectorAll("input[name='gender']");
            radiobtn.forEach(btn => btn.addEventListener("click", handleGenderInput));
            return;
        }
        employeeIndex++;
        if (employeeFormInputDiv && employeeIndex == employeeFormInputDiv.length) {
            document.getElementById("flush-collapseOne")?.classList.remove("show");
            document.getElementById("flush-collapseTwo")?.classList.add("show");
            if (vehicleFormInputDiv) {
                vehicleFormInputDiv[vehicleIndex].classList.remove("d-none");
                vehicleFormInputDiv[vehicleIndex].classList.add("d-flex");
                (vehicleFormInputDiv[vehicleIndex].lastElementChild as HTMLDivElement).focus();
                (vehicleFormInputDiv[vehicleIndex].lastElementChild as HTMLDivElement).addEventListener("keypress", handleVehcSectInputKeyPress);
            }
            const employeeID = generateEmployeeId();
            ptag && (ptag.innerHTML = "Employee ID: " + employeeID);
            (document.getElementById('vEmpId') as HTMLInputElement).value = employeeID;
            alert("Employee ID: " + employeeID);
            return;
        } else {
            if (employeeFormInputDiv) {
                employeeFormInputDiv[employeeIndex].classList.remove('d-none');
                employeeFormInputDiv[employeeIndex].classList.add('d-flex');
                (employeeFormInputDiv[employeeIndex].lastElementChild as HTMLInputElement).focus();
                (employeeFormInputDiv[employeeIndex].lastElementChild as HTMLInputElement).addEventListener("keypress", handleEmpSectInputKeyPress);
            }
        }

    }
}


employeeFormInputDiv && ((employeeFormInputDiv[employeeIndex] as HTMLInputElement).lastElementChild as HTMLInputElement).addEventListener("keypress", handleEmpSectInputKeyPress);


















