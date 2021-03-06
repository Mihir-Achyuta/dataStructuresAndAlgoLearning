//problem solving skills which sometimes come up

//Frequency Counter uses objects to store amounts of data

//Check to see if array 2 is array[1]^2 exactly
//brute force O(n^2) solution with nested loops
function same( arrayone, arraytwo){
    if(arrayone.length !== arraytwo.length){
        return false;
    }
    for(var i =0; i<arrayone.length; i++){
        var current = arraytwo.indexOf(arrayone[i]*arrayone[i]);
        if(current === -1){
            return false;
        }
        arraytwo.splice(current,1);

    }
    return true;
}

console.log("Brute Force Solution")
var array5 = [1,2,3];
var array6 = [1,9];
//returns false
//console.log(same(array5, array6));

var array3 = [1,2,3];
var array4 = [4,1,9];
console.log(same(array3,array4));

//using Java Script objects for O(n) solution

function sameObject(array1, array2){
    if(array1.length !== array2.length){
        return false;
    }

    frequencyCounter1 = {};
    frequencyCounter2 = {};

    for(var i of array1){
        frequencyCounter1[i] = (frequencyCounter1[i] || 0) + 1;
    }
    for(var i of array2){
        frequencyCounter2[i] = (frequencyCounter2[i] || 0) + 1;
    }

    for(var i in frequencyCounter1){
        if(!(i*i in frequencyCounter2)){
            return  false;
        }
        if(frequencyCounter1[i] !== frequencyCounter2[i*i]){
            return false;
        }
    }
    return true;
}

console.log("Frequency Counter Solution");
var array3 = [1,2,3,3];
var array4 = [4,1,9,12];
console.log(sameObject(array3,array4));

//check to see if strings are anagrams
function anagram(str1, str2){
    if(str1.trim().length === 0 && str2.trim().length ===0){
        return true;
    }

    if(str1.length !== str2.length){
        return false;
    }
    var obj1 = {};
    var obj2 = {};

    for(var i of str1){
        obj1[i] = (obj1[i] || 0) + 1;
    }
    for(var i of str2){
        obj2[i] = (obj2[i] || 0) + 1;
    }

    for(var i  in obj1){
        if(!(i in obj2)){
            return false;
        }
        if(obj1[i] !== obj2[i]){
            return false;
        }
    }
    return true;
}
console.log("Anagram Frequency Counter Solution");
console.log(anagram("texttwisttime","timetwisttext"));

//checks if numbers have the same frequency of digits
function sameFrequency(num1,num2) {
    var first = num1 + "";
    var second = num2 + "";

    var firstFreq = {};
    var secondFreq = {};

    if(first.length !== second.length){
        return false;
    }

    for(var i of first){
        firstFreq[i] = (firstFreq[i] || 0) + 1;
    }
    for(var i of second){
        secondFreq[i] = (secondFreq[i] || 0) +1;
    }

    for(var i in firstFreq){
        if(firstFreq[i] !== secondFreq[i]){
            return false;
        }
    }
    return true;
}

console.log("Same Frequency");
console.log(sameFrequency(34,14));

//finds if a variable number of arguments have any duplicates
function areThereDuplicates() {
    var collector = {};
    for(var i of arguments){
        collector[i] = (collector[i] || 0) +1;
    }
    for(var i in collector){
        if(collector[i] === 2){
            return true;
        }
    }
    return false;
}
console.log("Variable Duplicates")
console.log(areThereDuplicates("a","b","c","a"));

//Multiple Pointers creates pointers based on index and approaches a certain value based on problem

//finds first pair of numbers that add up to 0
//Brute Force O(n^2) with nested loops
function BruteSum(array){
    for(var i =0; i<array.length-1; i++){
        for(var j =i+1; j<array.length; j++){
            if(array[i] + array[j] === 0){
                console.log(i,j);
                return true;
            }
        }
    }
    return false;
}

var testArray = [-4,-3,-2,-1,0,1];
//BruteSum(testArray);

function sumZero(array) {
    var start = 0;
    var end = array.length-1;
    if(array[start] + array[end] === 0){
        console.log(start, end);
    }
    else{
        while(array[start] !== array[end]){
            if(array[start] + array[end] === 0){
                console.log(start,end);
                break;
            }
            if(array[start] + array[end] > 0){
                end--;
            }
            if(array[start] + array[end] < 0){
                start++;
            }
        }
    }

}
console.log("First Pair That Sums to Zero")
sumZero(testArray);

//finds unique numbers in array
function countUniqueValues(array) {
    var count = 0;
    if(array.length === 0){
        return 0;
    }
    for(var i =0; i<array.length-1; i++){
        if(array[i] !== array[i+1]){
            count++;
        }
    }
    return count + 1;
}

var testArray = [1,2,3,4,4,4,7,7,12,12,13];
console.log("Unique Values In An Array");
console.log(countUniqueValues(testArray));

//finds if a pair of numbers exists that satisfies the average
function averagePair(array,average) {
    var start = 0;
    var end = array.length-1;
    while(start<end){
        var calcAvg = (array[start] + array[end])/2;
        if(calcAvg === average){
            return true;
        }
        else if(calcAvg>average){
            end--;
        }
        else if(calcAvg<average){
            start++;
        }
    }
    return false;
}
console.log("Average Pair");
console.log(averagePair([1,2,3], 2));

//Sliding Window creates a new window if needed or stores info based on the problem

//finds the maximum of a set of numbers
function maxSubarraySum(array,setNum){
    if(setNum>array.length){
        return 0;
    }
    var maxSum =0;
    var tempSum = 0;
    for(var i =0; i<setNum; i++){
        maxSum += array[i];
    }
    tempSum = maxSum;
    for(var i =setNum; i<array.length; i++){
        tempSum = tempSum - array[i-setNum] + array[i];
        maxSum = Math.max(maxSum,tempSum);
    }
    return maxSum;
}

var testArray = [4,2,1,6,2];
set = 4;
console.log("Max Sum")
console.log(maxSubarraySum(testArray,4));