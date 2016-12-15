var http = require('http');
var port = 80;
process.on('uncaughtException', function(err) {
    console.error(err);
});
var sleepTime = 0;
http.createServer(function (req, res) {
        console.log('access');
    setTimeout(function () {
        res.writeHead(200, {'Content-Type': 'text/plain'});
        res.end('{}');
    }, sleepTime);
})
    .listen(port, function() {
                console.log('start sert port: ' + port);
    });
