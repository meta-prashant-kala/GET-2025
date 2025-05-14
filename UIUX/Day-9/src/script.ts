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
    empId:string,
    name:string,
    gender:string,
    email:string,
    password:string,
    number:string
}
interface Vehicle{
    name:string,
    type:string,
    vehNumber:string,
    empId:string,
    identification:string
}

const employeeData: Partial<Employee>={};
const vehicleData: Partial<Vehicle>={};

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
    return employeeData.empId=employeeId;
}

const convertYenToDollar=(currency: number)=>{
    return (currency/143).toFixed(3)
}

const convertRupeeTodollar=(currency : number)=>{
    return (currency/84).toFixed(3)
}

const handleGenderInput = (event: Event) => {
    employeeData.gender=(event.target as HTMLInputElement).value;
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
        (currentFocusedInput.lastElementChild as HTMLInputElement).removeEventListener("keypress", handleEmpSectInputKeyPress);
    }

    if(vehicleFormInputDiv){
        const currentInput = vehicleFormInputDiv[vehicleIndex];
        currentInput.classList.remove('d-none');
        currentInput.classList.add('d-flex');
        (currentInput.lastElementChild as HTMLInputElement).addEventListener("keypress", handleVehcSectInputKeyPress);
    }
}

const handleEmployeeClick = (element: HTMLElement) => {
    if(vehicleFormInputDiv){
        const currentFocusedInput = vehicleFormInputDiv[employeeIndex];
        currentFocusedInput.classList.remove('d-flex');
        currentFocusedInput.classList.add('d-none');
        (currentFocusedInput.lastElementChild as HTMLInputElement).removeEventListener("keypress", handleVehcSectInputKeyPress);
    }
    if(employeeFormInputDiv){
        const currentInput = employeeFormInputDiv[vehicleIndex];
        currentInput.classList.remove('d-none');
        currentInput.classList.add('d-flex');
        (currentInput.lastElementChild as HTMLInputElement).addEventListener("keypress", handleEmpSectInputKeyPress);
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
    const planPrice = Number((element.getElementsByTagName('div')[0].lastElementChild as HTMLElement).innerHTML);

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
        employeeData.name=(document.getElementById('fullName') as HTMLInputElement).value;
        employeeData.email=(document.getElementById('email') as HTMLInputElement).value;
        employeeData.number=(document.getElementById('contactNumber') as HTMLInputElement).value;

        vehicleData.name=(document.getElementById('vName') as HTMLInputElement).value ?? "";
        vehicleData.type=(document.getElementById('vType') as HTMLSelectElement).value ?? "";
        vehicleData.vehNumber=(document.getElementById('vNumber') as HTMLSelectElement).value ?? "";
        vehicleData.identification=(document.getElementById('identification') as HTMLSelectElement).value ?? "";

        (document.getElementById('pass-emp-id') as HTMLSpanElement).textContent+=employeeData.empId ?? "";
        (document.getElementById('pass-veh-num')as HTMLSpanElement).textContent+=vehicleData.vehNumber;
        (document.getElementById('pass-sel-plan') as HTMLSpanElement).textContent+=selectedPlan + "$" + " ( " + planDuration + " )";
        (document.getElementById('generatePassBtn') as HTMLSpanElement).classList.add('d-none');
        (document.querySelector('.pass-generated-section') as HTMLSpanElement).classList.remove('d-none');
        (document.querySelector('.pass-generated-section') as HTMLSpanElement).classList.add('d-flex');

        localStorage.setItem("empData",JSON.stringify(employeeData));
        localStorage.setItem("vehData",JSON.stringify(vehicleData));
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

        if (vehicleFormInputDiv && (vehicleFormInputDiv[vehicleIndex].lastElementChild as HTMLLabelElement).id === 'vType') {
            selectedVehicleType = (vehicleFormInputDiv[vehicleIndex].lastElementChild as HTMLInputElement).value;
        }
        if(vehicleFormInputDiv){
            (vehicleFormInputDiv[vehicleIndex].lastElementChild as HTMLInputElement).removeEventListener("keypress", handleVehcSectInputKeyPress);
            vehicleFormInputDiv[vehicleIndex].classList.remove('d-flex');
            vehicleFormInputDiv[vehicleIndex].classList.add('d-none');
        }
        vehicleIndex++;
        if (vehicleFormInputDiv && vehicleIndex == vehicleFormInputDiv.length) {
            (document.getElementById("flush-collapseTwo") as HTMLElement).classList.remove("show");
            selectedVehicleType = (document.getElementById('vType') as HTMLInputElement).value;
            rupeePriceList = getRupeePriceList(selectedVehicleType) ?? [];
            setPricingOfPricingSection(rupeePriceList);
            (document.getElementById("price-section") as HTMLElement).classList.remove('d-none');
            (document.getElementById("price-section") as HTMLElement).classList.add('d-flex');
            (document.getElementById('currency-opions') as HTMLElement).getElementsByTagName('button')[0].classList.remove('btn-secondary');
            (document.getElementById('currency-opions') as HTMLElement).getElementsByTagName('button')[0].classList.add('bg-custom-color');
            currencyType='rupee';
            if (selectedVehicleType === 'cycle') {
                (document.getElementById("price-section-head") as HTMLElement).innerHTML += " Cycle"
            }
            else if (selectedVehicleType === 'motorCycle') {
                (document.getElementById("price-section-head") as HTMLElement).innerHTML += " Motor Cycle"
            }
            else if (selectedVehicleType === 'fourWheeler') {
                (document.getElementById("price-section-head") as HTMLElement).innerHTML += " Four Wheeler"
            }
            return;
        } else {
            if(vehicleFormInputDiv){
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
    const currentVal = event.key.length === 1 ? (event.target as HTMLInputElement).value + event.key : (event.target as HTMLInputElement).value;

    if (event.key === "Enter") {

        if ((event.target as HTMLInputElement).id === 'fullName' && currentVal.length <= 2) {
            (document.getElementById("emp-error-field") as HTMLElement).textContent = "Name cannot be this short";
            return;
        } else if ((event.target as HTMLInputElement).id === 'email' && !(/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(currentVal))) {
            (document.getElementById("emp-error-field") as HTMLElement).textContent = "Invalid email";
            return;
        } else if ((event.target as HTMLInputElement).id === 'password') {
            const passwordErrorTag = document.getElementById('emp-error-field');
            if (!(/[A-Z]/.test(currentVal))) {
                (document.getElementById("password") as HTMLElement).style.boxShadow = '0px 0px 10px red';
                (passwordErrorTag as HTMLElement).textContent = "Password must contain one upper case letter";
                (passwordErrorTag as HTMLElement).classList.add('text-danger');
                return;
            } else if (!(/[a-z]/.test(currentVal))) {
                (document.getElementById("password") as HTMLElement).style.boxShadow = '0px 0px 1px red';
                (passwordErrorTag as HTMLParagraphElement).textContent = "Password must contain one lower case letter";
                (passwordErrorTag as HTMLParagraphElement).classList.add('text-danger');
                return;
            } else if (currentVal.length <= 8) {
                (document.getElementById("password") as HTMLParagraphElement).style.boxShadow = '0px 0px 10px orange';
                (passwordErrorTag as HTMLElement).textContent = "Password must be longer than 8 letter";
                (passwordErrorTag as HTMLElement).classList.add('text-danger');
                return;
            }
            (document.getElementById("password") as HTMLParagraphElement).style.boxShadow = '0px 0px 10px green';
        } else if ((event.target as HTMLInputElement).id === 'confirmPassword') {
            if ((document.getElementById("password") as HTMLInputElement).value.length > 0 && currentVal !== (document.getElementById("password") as HTMLInputElement).value) {
                (document.getElementById("emp-error-field") as HTMLParagraphElement).textContent = "Password do not match";
                return;
            }
        } else if ((event.target as HTMLInputElement).id === 'contactNumber') {
            if (currentVal.length < 10) {
                (document.getElementById("emp-error-field") as HTMLParagraphElement).textContent = "Invlid phone number";
                return;
            }
        }

        (document.getElementById("emp-error-field") as HTMLParagraphElement).textContent = "";

        if(employeeFormInputDiv){
            (employeeFormInputDiv[employeeIndex].lastElementChild as HTMLInputElement).removeEventListener("keypress", handleEmpSectInputKeyPress);
            employeeFormInputDiv[employeeIndex].classList.remove('d-flex');
            employeeFormInputDiv[employeeIndex].classList.add('d-none');
        }
        if (employeeIndex == 0) {
            (ptag as HTMLParagraphElement).innerText = `Hi ${(employeeFormInputDiv && (employeeFormInputDiv[employeeIndex].lastElementChild as HTMLInputElement).value)}, Can i know your gender`
            document.getElementById("genderDiv")?.classList.remove('d-none');
            document.getElementById("genderDiv")?.classList.add('d-flex');
            const radiobtn = document.querySelectorAll("input[name='gender']");
            radiobtn.forEach(btn => (btn as HTMLInputElement).addEventListener("click", handleGenderInput));
            return;
        }
        employeeIndex++;
        if (employeeFormInputDiv && employeeIndex == employeeFormInputDiv.length) {
            document.getElementById("flush-collapseOne")?.classList.remove("show");
            document.getElementById("flush-collapseTwo")?.classList.add("show");
            if(vehicleFormInputDiv){
                vehicleFormInputDiv[vehicleIndex].classList.remove("d-none");
                vehicleFormInputDiv[vehicleIndex].classList.add("d-flex");
                (vehicleFormInputDiv[vehicleIndex].lastElementChild as HTMLInputElement).focus();
                (vehicleFormInputDiv[vehicleIndex].lastElementChild as HTMLInputElement).addEventListener("keypress", handleVehcSectInputKeyPress);
            }
            const employeeID = generateEmployeeId();
            (ptag as HTMLParagraphElement).innerHTML = "Employee ID: " + employeeID;
            (document.getElementById('vEmpId') as HTMLInputElement).value = employeeID;
            alert("Employee ID: " + employeeID);
            return;
        } else {
            if(employeeFormInputDiv){
                employeeFormInputDiv[employeeIndex].classList.remove('d-none');
                employeeFormInputDiv[employeeIndex].classList.add('d-flex');
                (employeeFormInputDiv[employeeIndex].lastElementChild as HTMLInputElement).focus();
                (employeeFormInputDiv[employeeIndex].lastElementChild as HTMLInputElement).addEventListener("keypress", handleEmpSectInputKeyPress);
            }
        }

    }
}

if(employeeFormInputDiv){

    (employeeFormInputDiv[employeeIndex].lastElementChild as HTMLInputElement).addEventListener("keypress", handleEmpSectInputKeyPress);
}



















