const wordPattern = function(pattern, str) {
    const a = pattern.split('');
    const b = str.split(' ');
    let pt = [];
    let x={};
    
    if(a.length !== b.length) return false;
    
    for(var i=0; i<a.length; i++){
        if(!x[a[i]]){
            x[a[i]] = b[i];
            if(pt.indexOf(b[i])!== -1) return false;
            pt.push(b[i]);
        }
        else if(x[a[i]]!==b[i]) return false;
    }
    return true
};
