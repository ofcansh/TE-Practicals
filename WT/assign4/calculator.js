const display = document.getElementById('display');

function appendToDisplay(value) {
    if (value === 'sqrt') {
        display.value += 'Math.sqrt(';
    } else {
        display.value += value;
    }
}

function clearDisplay() {
    display.value = '';
}

function backspace() {
    display.value = display.value.slice(0, -1);
}

function calculateResult() {
    try {
        let expression = display.value.replace(/\^/g, '**');
        display.value = eval(expression);
    } catch (error) {
        display.value = 'Error';
    }
}
