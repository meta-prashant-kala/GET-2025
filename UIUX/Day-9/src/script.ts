let employeeIndex = 0;
let vehicleIndex = 0;
let employeeId:string;
let selectedVehicleType: string;
let rupeePriceList:number[];
let selectedPlan:number;
let planDuration:String;
let currencyType:string;
let isPlanSelected=false;
const ptag = document.getElementById("person-name");

interface Employee{
    name:string
}

const employeeData: Partial<Employee>={};

(document.getElementById('accordion-item-1') as HTMLDivElement).getElementsByTagName('div')[employeeIndex].classList.add('show');
const employeeForm = document.getElementById("employee-form");
const employeeFormInputDiv = employeeForm?.getElementsByTagName("div");
if(employeeFormInputDiv){
    employeeFormInputDiv[employeeIndex].classList.remove('d-none');
employeeFormInputDiv[employeeIndex].classList.add('d-flex');
(employeeFormInputDiv[employeeIndex].lastElementChild as HTMLInputElement).focus();
}

const vehicleForm = document.getElementById("vehicle-form");
const vehicleFormInputDiv = vehicleForm?.getElementsByTagName("div");

const generateEmployeeId = () => {
    const formDivList = (document.getElementById("employee-form") as HTMLDivElement).getElementsByTagName('div');
    employeeId = (document.getElementById('vEmpId') as HTMLInputElement).value + Math.floor(Math.random() * 1000);
    return employeeId;
}

const convertYenToDollar=(currency: number)=>{
    return (currency/143).toFixed(3)
}

const convertRupeeTodollar=(currency : number)=>{
    return (currency/84).toFixed(3)
}

const handleGenderInput = (event: KeyboardEvent) => {
    (document.getElementById('genderDiv') as HTMLDivElement).classList.remove("d-flex");
    (document.getElementById('genderDiv') as HTMLDivElement).classList.add("d-none");
    employeeIndex += 3;
    if(employeeFormInputDiv){
        employeeFormInputDiv[employeeIndex].classList.remove('d-none');
    employeeFormInputDiv[employeeIndex].classList.add('d-flex');
    (employeeFormInputDiv[employeeIndex].lastElementChild as HTMLInputElement).focus();
    (employeeFormInputDiv[employeeIndex].lastElementChild as HTMLInputElement).addEventListener("keypress", handleEmpSectInputKeyPress);
    employeeFormInputDiv[0].setAttribute('style', 'display:none !important');
    }
    ptag &&( ptag.innerText = "");
}

const setPricingOfPricingSection = (priceList:number[]) => {
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
}

const handleVehicleClick = (element: HTMLElement) => {
    if(employeeFormInputDiv){
        const currentFocusedInput = employeeFormInputDiv[employeeIndex];
        currentFocusedInput.classList.remove('d-flex');
        currentFocusedInput.classList.add('d-none');
        currentFocusedInput.lastElementChild?.removeEventListener("keypress", handleEmpSectInputKeyPress);
    }

    if(vehicleFormInputDiv){
        const currentInput = vehicleFormInputDiv[vehicleIndex];
        currentInput.classList.remove('d-none');
        currentInput.classList.add('d-flex');
        currentInput.lastElementChild?.addEventListener("keypress", handleVehcSectInputKeyPress);
    }
}

const handleEmployeeClick = (element: HTMLElement) => {
    if(vehicleFormInputDiv){
        const currentFocusedInput = vehicleFormInputDiv[employeeIndex];
        currentFocusedInput.classList.remove('d-flex');
        currentFocusedInput.classList.add('d-none');
        currentFocusedInput.lastElementChild?.removeEventListener("keypress", handleVehcSectInputKeyPress);
    }
    if(employeeFormInputDiv){
        const currentInput = employeeFormInputDiv[vehicleIndex];
        currentInput.classList.remove('d-none');
        currentInput.classList.add('d-flex');
        currentInput.lastElementChild?.addEventListener("keypress", handleEmpSectInputKeyPress);
    }
}

const handleSelectedCurrency = (selectedCurrency: string) => {
    let selectedCurrencyPriceList;
    const currencyList = document.getElementById('currency-opions')?.getElementsByTagName('button');
    if(currencyList){
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
    selectedCurrencyPriceList && setPricingOfPricingSection(selectedCurrencyPriceList);
}

const handleSelectedPlan = (element: HTMLElement) => {
    isPlanSelected=true
    const elementsList = document.getElementById("price-list")?.getElementsByTagName('div');
    if(elementsList){
        for (const element of elementsList) {
            element.classList.remove('bg-custom-color');
        }
        element.classList.add('bg-custom-color');
    }
    selectedPlan = Number(element.id);
    planDuration = (element.getElementsByTagName('div')[0].firstElementChild as HTMLElement).innerHTML;
    const planPrice = Number(element.getElementsByTagName('div')[0].lastElementChild as HTMLElement).innerHTML;

    if(currencyType=='rupee'){
        selectedPlan=Number(convertRupeeTodollar(planPrice));
    }
    else if(currencyType=='yen'){
        selectedPlan=Number(convertYenToDollar(planPrice))
    }else {
        selectedPlan=planPrice;
    }   
}


const generatePass = () => {
    if(!isPlanSelected){
        alert("Please Select a plan");
        return;
    }
    else{
        (document.getElementById('pass-emp-id') as HTMLSpanElement).textContent+=employeeId;
        (document.getElementById('pass-veh-num')as HTMLSpanElement).textContent+=(document.getElementById('vNumber') as HTMLInputElement).value;
        (document.getElementById('pass-sel-plan') as HTMLSpanElement).textContent+=selectedPlan + "$" + " ( " + planDuration + " )";
        (document.getElementById('generatePassBtn') as HTMLSpanElement).classList.add('d-none');
        (document.querySelector('.pass-generated-section') as HTMLSpanElement).classList.remove('d-none');
        (document.querySelector('.pass-generated-section') as HTMLSpanElement).classList.add('d-flex');
    }
}


const handleVehcSectInputKeyPress = (event : KeyboardEvent) => {
    (document.getElementById("veh-error-field") as HTMLParagraphElement).textContent = "";

    const currentVal = event.key.length === 1 ? (event.target as HTMLInputElement).value + event.key : (event.target as HTMLInputElement).value;

    if (event.key === "Enter") {

    
        if ((event.target as HTMLDivElement).id === 'vName' && currentVal.length < 2) {
            (document.getElementById("veh-error-field") as HTMLParagraphElement).textContent = "Vehicle name cannot be this short";
            return;
        }
        else if ((event.target as HTMLDivElement).id === 'vType') {
            (document.getElementById('vTypeLabel') as HTMLParagraphElement).innerHTML = "Which vehicle do you have";
        }
        else if ((event.target as HTMLDivElement).id === 'vNumber' && !(/^[A-Z]{2}\d{2}[A-Z]{2}\d{4}$/i.test(currentVal))) {
            (document.getElementById("veh-error-field") as HTMLParagraphElement).textContent = "Invalid Vehicle number";
            return;
        }
        else if ((event.target as HTMLDivElement).id === 'vEmpId' ) {
            if(currentVal.length<2){
                (document.getElementById("veh-error-field") as HTMLParagraphElement).textContent = "Invalid Employee ID";
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
            currencyType='rupee';
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


const handleEmpSectInputKeyPress = (event) => {
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


employeeFormInputDiv[employeeIndex].lastElementChild.addEventListener("keypress", handleEmpSectInputKeyPress);


















