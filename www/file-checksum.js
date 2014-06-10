var exec = require('cordova/exec');

var FileChecksum = function(){};

FileChecksum.prototype.getChecksum = function(file){
    exec(
        function successCallback(resp){
            return resp;
        },
        function errorCallback(err){
            return err;
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