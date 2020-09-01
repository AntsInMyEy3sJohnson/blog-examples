from http.server import SimpleHTTPRequestHandler
import json
import socketserver

class HelloContainerRequestHandler(SimpleHTTPRequestHandler):

    def do_GET(self):
        self._set_headers()
        self.wfile.write(json.dumps({'message': 'Hello, container!'}).encode())

    def _set_headers(self):
        self.send_response(200)
        self.send_header('Content-Type', 'application/json')
        self.end_headers()


port = 8081
handler = HelloContainerRequestHandler

with socketserver.TCPServer(("", port), handler) as httpd:
    print("Starting to serve on port", port)
    httpd.serve_forever()

