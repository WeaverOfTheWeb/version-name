var exec = require('cordova/exec');

module.exports = {
    getVersionName: function (packageName, success, error) {
        exec(success, error, 'VersionName', 'getVersionName', [packageName]);
    }
};
