var exec = require('cordova/exec');

var FileChecksum = function(){};

FileChecksum.prototype.getChecksum = function(file,success, fail){
    
    exec(
        function successCallback(resp){
            console.log('success, sending response');
            success(resp);
        },
        function errorCallback(err){
            if(typeof fail === 'undefined'){
                fail = function(){ console.log('failed getChecksum');};
            }
            else{
                fail(err);
            }
        },
        'FileChecksum',
        'getChecksum',
        [file]
    );
};

FileChecksum.prototype.getChecksums = function(files){
    exec(
        function successCallback(resp){
            return resp;
        },
        function errorCallback(err){
            return err;
        },
        'FileChecksum',
        'getChecksums',
        [files]
    );
};

FileChecksum.prototype.compareFileToChecksum = function(filesWithChecksum){
    exec(
        function successCallback(resp){
            return resp;
        },
        function errorCallback(err){
            return err;
        },
        'FileChecksum',
        'compareFileToChecksum',
        [filesWithChecksum]
    );
};

module.exports = FileChecksum;