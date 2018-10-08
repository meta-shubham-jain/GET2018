import {add} from './modules/math-functions';

const result = document.getElementById('result');

result.addEventListener("click", function(){

	const firstNumber = parseInt(document.getElementById("firstNumber").value,10);
	const secondNumber = parseInt(document.getElementById("secondNumber").value,10);
	const resultAdd = document.getElementById('resultAdd');

	resultAdd.textContent = `The sum of ${firstNumber} and ${secondNumber} is ${add(firstNumber)(secondNumber)}.`;

});
