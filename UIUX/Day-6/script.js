let index = 0;


const element = document.getElementById("test");
const input = element.getElementsByTagName("input");


input[index].focus();
input[index].addEventListener("keypress", handleKeyPress);

function handleKeyPress(event) {
    if (event.key === "Enter") {
        input[index].removeEventListener("keypress", handleKeyPress);
        input[index].classList.remove('d-flex');
        input[index].classList.add('d-none');
        index++;
        if (index >= input.length) {
            console.log("No more inputs!");
            return;
        }
        const newInput = document.getElementById("test").getElementsByTagName("input");
        newInput[index].classList.remove('d-none');
        newInput[index].classList.add('d-flex');
        newInput[index].focus();
        newInput[index].addEventListener("keypress", handleKeyPress);
    }
}
