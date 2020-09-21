function removeduplicatetype1(input) {
    return [...new Set(input)];
}
function sumUp(input) {
    let result = 0;
    input.forEach(a => result += a);
    return result;
}
console.log(removeduplicatetype1([1, 2, 1, 2, 3, 5, 3]));
console.log(sumUp([1, 2, 1, 2, 3, 5, 3]));
//# sourceMappingURL=myquiz.js.map