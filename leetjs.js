
//revert string
let reverseString1 = function(s) {
    if (!s || 0===s.length || 1===s.length) {
        return s;
    }
    
    return s.reverse();
    
};

let reverseString2 = function(s) {
    if (s && s.length !==1) {
        l=s.length;
        for (let i=0, j=l-1;i<j;i++, j--) {
            tmp=s[i];
            s[i]=s[j];
            s[j]=tmp;
        }
        
    }
};
var reverseVowels = function(s) {
    o='aeiou';
    if (!s || s.length == 1 || !(/[aeiou]/gi.test(s))) {
        console.log("no match");
        return s;
    }
        console.log("inside");
        let l=s.length;
        let arr=s.trim().split("");
        for (let i=0,j=l-1;i<j;) {
            if (o.indexOf(arr[i].toLowerCase())>0 && o.indexOf(arr[j].toLowerCase())>0) {
                console.log("matches: "+arr[i] + " " + arr[j]);
                tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
                console.log("matches: "+arr[i] + " " + arr[j]);
                i++;
                j--;
            } else {
               if (o.indexOf(arr[i].toLowerCase())===-1) {
                   console.log("i not match: " + arr[i] + " " +arr[j]);
                   i++;
               }
                 if (o.indexOf(arr[j].toLowerCase())===-1) {
                    console.log("j not match : " + arr[i]+ " " + arr[j]);
                    j--;
              }
            }
        }
        return arr.join("");
    }
 console.log(reverseVowels("hello"));

//time exceeding limits
var lt_reverseVowels = function(s) {
   o='aeiou';
   // if (!s || s.length == 1 || !(/[aeiou]/gi.test(s))) {
    if (!s || s.length==1) {
        return s;
    }
    if (!(/[aeiou]/gi.test(s))) {
        return s;
    }
    
        let l=s.length;
        let arr=s.split("");
        for (let i=0,j=l-1;i<j;) {
            if (o.indexOf(arr[i])>0 && o.indexOf(arr[j])>0) {
                /**
                tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
                **/
                [arr[i], arr[j]] = [arr[j], arr[i]];
                i++;
                j--;
            } else {
               if (o.indexOf(arr[i])===-1) {
                   i++;
               }
                 if (o.indexOf(arr[j])===-1) {
                    j--;
              }
            }
        }
        return arr.join("");
    };
    //javascript string manipulations
    var lt_reverseVowels = function(s) {
    pattern='aeiouAEIOU';
    //get vowels out first from string
    vowels=Array(...s).filter(x => pattern.includes(x));
    result='';
    for (let e of s) {
        if (!pattern.includes(e)) {
            result+=e;
        } else {
            result+=vowels.pop();
        }
    }
    return result;
   
}

//remove vowels from a string

//reverse substring based on index k
let lt_reverseStr = function(s, k) {
    let l=s.length;
    if (l==1) {
        return s;
    }
    if (l<k) return s.split('').reverse().join('');
    
    let result='';
   
    //looping to get the substring
    for (let i=0;i<l;i+=2*k) {
      
        result+=s.substring(i,i+k).split('').reverse().join('') + s.substring(i+k, i+2*k);
         
    }
   
    return result;
 
};
console.log(lt_reverseStr("abcdefg", 2));

//reverse word in a sentence
let lt_reverseWords = function(s) {
    if (!s || s.length==1) return s;
    return s.split(" ").map(x => x.split("").reverse().join("")).join(" ");
    
};

let lt_mostCommonWord = function(paragraph, banned) {
     
    //split string to array with non-word separator using map
    let total=paragraph.toLowerCase().split(/["\W"]+/g);
    //get the list that does not include banned item using filter
    total=total.filter(a => (banned.map(e=>e.toLowerCase())).indexOf(a) === -1);
    
    //convert the array into objects using reduce that contains word as key and count as value
    total=total.reduce((total, element) => {
        const count=total[element]?total[element]+1:1;
        return total={...total, [element]:count}
        
    }, {}); 
     
    //get the largets value from object using reduce (reduce on Object.keys(totals))
    return Object.keys(total).reduce((a, b) => {
           return total[a]>=total[b]?a:b;
    });
    
};

//recursive for trees
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var lt_maxDepth = function(root) {
    if (!root) {
        return 0;
    }
    if (!root.left && !root.right) {
        return 1
    }
    
    return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    
};

//find the single number
let lt_singleNumber = function(nums) {
    if (!nums) {
        return null;
    }
    if (nums.length==1) {
        return nums[0];
    }
    
    let target=nums.reduce((target, element) => {
        target[element]=target[element]?target[element]+1:1;
        return target;
    }, {});
    
    for (const property in target) {
       if (target[property]===1) return property
    }
    
    return null;
    
};

var lt_fizzBuzz = function(n) {
    let result=[];
    
    if (n<3) {
        for (let i=1;i<=n;i++) {
          result.push(''+i);
        }
        return result;
    }
    
    for (let i=1;i<=n;i++) {
        
        if ( (i+3)%3===0 && (i+5)%5===0) {
            result.push("FizzBuzz");
        } else if ((i+3)%3===0) {
            result.push("Fizz");
        } else if ((i+5)%5===0) {
            result.push("Buzz");
        } else {
            result.push(i.toString());
        }
    }
    return result;
    
};
var lt_reverseList1 = function(head) {
    
   if (head===null || head.next===null) return head;
    
   let pre=null;
   let node=null
   while (head) {
       node=new ListNode();
       node.val=head.val;
       node.next=pre;
       pre=node;
       head=head.next;
   }
   return node;
}

var lt_reverseList2 = function(head) {
    if (head===null || head.next===null) {
        return head;
    }
    let pre=null;
    let newnode=null;
    function reverseListNode1(newhead) {
      if (newhead != null) {
        newnode=new ListNode();
        newnode.next=pre;
        newnode.val=newhead.val;
        pre=newnode;
        reverseListNode1(newhead.next);
      }
      return newnode;
    }
    return reverseListNode1(head);
}

var lt_deleteNode = function(node) {
    
    node.val=node.next.val;
    node.next=node.next.next;
    
    
};
var lt_majorityElement = function(nums) {
    
    const mapr=nums.reduce( (result, element) => {
        result[element]=result[element]?result[element]+1:1;
        return result;
    }, {});
    
    
    const maxr=Object.keys(mapr).reduce( (a, b) => {
        return mapr[a] > mapr[b] ? a : b;
        
    });
    if (mapr[maxr] > nums.length/2) {
        return maxr
    } 
    return null;    
                                        
};


var lt_twoSum = function(nums, target) {
    if (nums !== null && nums.length>=2) {
   
    return nums.reduce( (newnum, element, index) => {
        let ei=nums.indexOf(element);
        let ri=nums.lastIndexOf(target-element);
        if (  ei != -1 && ri != -1 && !newnum.includes(ei) && !newnum.includes(ri) && (ei != ri)) {
            newnum.push(ei);
            newnum.push(ri);
        } 
        return newnum;
    }, []);
    } ;
    return null;
};

var lt_moveZeroes = function(nums) {
    let count=0;
    const l=nums.length;
    for (let i=0;i<l;i++) {
        let tmp=nums.shift();
        if (tmp!==0){
            nums.push(tmp);
        }  else {
          count++;
        }  
    }
    for (let i=0;i<count;i++) {
            nums.push(0);
    }
};
var lt_sortedArrayToBST = function(nums) {
    if (!nums || nums.length==0) {
        return null;
    }
    let m=Math.floor(nums.length/2);
    let node=new TreeNode(nums[m]);
    node.left=sortedArrayToBST(nums.slice(0, m));
    node.right=sortedArrayToBST(nums.slice(m+1));
    return node;
    
};
var lt_isAnagram = function(s, t) {
    
    if (s.length != t.length) {
        return false;
    }
   
    return s.split("").sort().join("") === t.split("").sort().join("");
   
};

var lt_isAnagram_smart_discussion = function(s, t) {
    if(s == "" && t =="") return true
    if(s.length != t.length) return false
    
    let hash = {}
    for (let char of s) {
        if(hash[char]) {
            hash[char]++
        } else hash[char] = 1
    }
    
    for (let char of t){
        if(!hash[char]) return false
        else if (hash[char] < 1) return false
        else hash[char]--
    } 
    return true    
};

var lt_maxProfit = function(prices) {
    
    let profit=0;
    for (let i=0;i<prices.length;i++) {
        if (prices[i+1]> prices[i]) {
            profit+=prices[i+1]-prices[i];
        }
    }
    return profit;
};
var lt_containsDuplicate = function(nums) {
    let nset=new Set(nums);
    
    if (nset.size != nums.length) return true;
    return false;
};

var lt_titleToNumber = function(s) {
    
    let elements=s.split("");
    let l=elements.length;
    
    let result=0;
    for (let i=l-1;i>=0;i--) {
        result+=(elements[i].charCodeAt(0)-64) * Math.pow(26, l-1-i);
    }
    return result;
};

var firstUniqChar = function(s) {
    
   let ss=s.split("");
   let initial=new Map();
   let counts=ss.reduce( (count, e) => {
        
         count.has(e)?count.set(e, count.get(e)+1):count.set(e, 1);
            
         return count;
    }, initial);

    for (const [k,v] of counts.entries()) {
       if  (v===1) {
           return ss.indexOf(k);
          
        }
    };
    return -1;
    
};

var firstUniqChar_2 = function(s) {
    
   let ss=s.split("");
   let initial={};
   let counts=ss.reduce( (count, e) => {
        
         (e in count)?count[e]+=1:count[e]=1;
            
         return count;
    }, {});

    for (const [k, v] of Object.entries(counts)) {
       if  (v===1) {
           return ss.indexOf(k);
          
        }
    };
    return -1;
    
};

var firstUniqChar_3 = function(s) {
    
  const ss=s.split("");

  for (const cc of ss) {
      if (s.indexOf(cc) === s.lastIndexOf(cc)) {
          return s.indexOf(cc);
      }
  }
  return -1;
    
};

var lt_mergeTwoLists_1 = function(l1, l2) {
    if (!l1) {
        return l2;
    }
    if (!l2) {
        return l1;
    }
    let newhead= new ListNode();
    let node=newhead;
    while (l1 && l2) {
        
        if (l1.val<=l2.val)  {
            node.val=l1.val;
            l1=l1.next; 
        } else  {
            node.val=l2.val;
            l2=l2.next;
        }
        
        if (l1 && l2) {
               node.next=new ListNode();
               node=node.next;
        } else {
            node.next=l1?l1:l2;
        }
    }
    return newhead;
};
var lt_mergeTwoLists_2 = function(l1, l2) {
    if (!l1) {
        return l2;
    }
    if (!l2) {
        return l1;
    }
    let newhead= new ListNode();
    let node=newhead;
    
    while (l1 && l2) {
        if (l1.val<=l2.val)  {
            node.next=l1;
            l1=l1.next; 
        } else  {
            node.next=l2;
            l2=l2.next;
        }
        node=node.next;
    }
    node.next=(l1?l1:l2);
    
    return newhead.next;
};


var lt_missingNumber = function(nums) {
    
    if (!nums || nums.length<0) {
        return 0;
    }
    if (nums.length===1) {
        return 1-nums[0];
    }
    let maxn=Math.max(...nums);
    
    for (let i=0;i<=maxn;i++) {
       if (nums.indexOf(i) === -1) {
           return i;
       }
    }
    return maxn+1;
    
};

paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
console.log(lt_mostCommonWord(paragraph, banned));
console.log(lt_twoSum([3, 3], 6));
console.log(lt_moveZeroes([0, 1, 0, 3, 12]));

console.log(" result index : " + firstUniqChar("leetcode"))
console.log(" result index : " + firstUniqChar("lleetcode"))