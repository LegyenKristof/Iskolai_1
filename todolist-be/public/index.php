<?php

use Illuminate\Database\Capsule\Manager;
use Slim\Factory\AppFactory;

require '../vendor/autoload.php';

$db = new Manager();

$db->addConnection([
    'driver' => 'sqlite',
    'database' => '../db/db.sqlite',
    'foreign_key_constraints' => true,
]);
$db->setAsGlobal();
$db->bootEloquent();

require '../src/db.php';


$app = AppFactory::create();

$app->addRoutingMiddleware();

/**
 * Add Error Middleware
 *
 * @param bool                  $displayErrorDetails -> Should be set to false in production
 * @param bool                  $logErrors -> Parameter is passed to the default ErrorHandler
 * @param bool                  $logErrorDetails -> Display error details in error log
 * @param LoggerInterface|null  $logger -> Optional PSR-3 Logger  
 *
 * Note: This middleware should be added last. It will not handle any exceptions/errors
 * for middleware added after it.
 */
$errorMiddleware = $app->addErrorMiddleware(true, true, true);

// routes
(require '../src/routes.php')($app);

// Run app
$app->run();
