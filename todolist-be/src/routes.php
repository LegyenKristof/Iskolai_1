<?php

use Petrik\Todolist15wl\Todo;
use Slim\App;
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Http\Message\ServerRequestInterface as Request;
use Slim\Exception\HttpNotFoundException;

return function(App $app) {
    $app->options('/{routes:.+}', function ($request, $response, $args) {
        return $response;
    });

    $app->add(function ($request, $handler) {
        $response = $handler->handle($request);
        return $response
            ->withHeader('Access-Control-Allow-Origin', '*')
            ->withHeader('Access-Control-Allow-Headers', 'X-Requested-With, Content-Type, Accept, Origin, Authorization')
            ->withHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, PATCH, OPTIONS');
    });

    $app->get('/', function (Request $request, Response $response) {
        $response->getBody()->write(\file_get_contents('index.html'));
        return $response;
    });


    $app->get('/todos', function(Request $request, Response $response) {
        $todos = Todo::all();

        $response->getBody()->write($todos->toJson());
        return $response
            ->withHeader('Content-Type', 'application/json');
    });

    $app->post('/todos', function (Request $request, Response $response) {
        $input = json_decode($request->getBody(), true);

        $todo = new Todo($input);
        $todo->save();

        $response->getBody()->write($todo->toJson());
        return $response
            ->withHeader('Content-Type', 'application/json');

    });

    $app->get('/todos/{id}', function (Request $request, Response $response, array $args) {
        $id = $args['id'];
        if (!is_numeric($id)) {
            throw new Exception('Id must be an integer');
        }
        $todo = Todo::find($id);
        $response->getBody()->write($todo->toJson());
        return $response
            ->withHeader('Content-Type', 'application/json');

    });

    $app->put('/todos/{id}', function(Request $request, Response $response, array $args) {
        $id = $args['id'];
        if (!is_numeric($id)) {
            throw new Exception('Id must be an integer');
        }

        $input = json_decode($request->getBody(), true);

        $todo = Todo::find($id);
        $todo->fill($input);
        $todo->save();

        $response->getBody()->write($todo->toJson());
        return $response
            ->withHeader('Content-Type', 'application/json');
    });


    /**
     * Catch-all route to serve a 404 Not Found page if none of the routes match
     * NOTE: make sure this route is defined last
     */
    $app->map(['GET', 'POST', 'PUT', 'DELETE', 'PATCH'], '/{routes:.+}', function ($request, $response) {
        throw new HttpNotFoundException($request);
    });
};
