//remove duplicates
function removeduplicatetype1(input:number[]):number[] {

    return [...new Set(input)];
   
}
//sumup
function sumUp(input:number[]):number {
    let result:number=0;
    input.forEach(a=>result+=a);
    return result;
}

console.log(removeduplicatetype1([1, 2, 1, 2, 3, 5, 3]));
console.log(sumUp([1, 2, 1, 2, 3, 5, 3]));