//repeatify
String.prototype.repeatify=String.prototype.repeatify|| function (times)  {

    let result='';
    for (let i=0;i<times;i++) {
        result+=this;
    }
    return result;
}

//doubleNumber with map
function doubleNumbers(arr) {
    let result=[];
    return arr.map(e =>  e*2);
    //console.log('result', result.toString());
    //return result;
}
//string it up using map
function stringItUp(arr) {
    let result=[];
    return arr.map(e => e.toString());
    //console.log('result', result.toString());
    //return result;
}
//remove duplicate with filter
function removeDuplicatesFilter(arr) {
    return arr.filter((element, index) => {return arr.indexOf(element)===index});
    //console.log('result', result.toString());
    //return result;
}

//remove duplicate with reducer
function removeDuplicatesReducer(arr) {
    return arr.reduce(reducer, []);
}

function reducer(accumulate, element) {
   if (!accumulate.includes(element)) {
       accumulate.push(element);
    }
    return accumulate;
}

//sum 2 numbers using currying
mysum=a => b => a+b; 
console.log(mysum(1)(2));

//sum 4 numbers using currying
mysum=a => b => c => d => a+b+c+d; 
console.log(mysum(1)(2)(3)(4));

arr=[1, 1, 3, 3, 2];
removeDuplicatesFilter2=arr.filter((value, index) =>  arr.indexOf(value) === index);

removeDuplicatesSet=[...new Set(arr)];
console.log(removeDuplicatesFilter([1, 1, 3, 3, 2]));
console.log(removeDuplicatesFilter2);
console.log(removeDuplicatesSet);

//convert string to array of characters
//1. using split
console.log("one".split(""));
//2. using spread 
console.log([..."two"]);
//3. using Array.from
console.log(Array.from("three"));
//4.Using Object.assign
console.log(Object.assign([], "four"));


console.log("abd".repeatify(5));
console.log(doubleNumbers([1, 2]));
console.log(stringItUp([4, 4]));
console.log(removeDuplicatesReducer([1, 1, 3, 3, 2]));




//javascript : array : includes, indexOf, splice(start, deleteNo, element...) : replace or insert elements into array