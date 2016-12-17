from wsgiref.util import setup_testing_defaults
from wsgiref.simple_server import make_server

def simple_app(environ, start_response):
    setup_testing_defaults(environ)

    status = '200 OK'
    headers = [('Content-type', 'text/plain; charset=utf-8')]

    start_response(status, headers)
    yield b'{"status": "success"}'

httpd = make_server('', 80, simple_app)
print("Serving on port 80...")
httpd.serve_forever()
