<?php

// Hosszú távon migrációkkal!

use Illuminate\Database\Capsule\Manager;
use Illuminate\Database\Schema\Blueprint;

if (!Manager::schema()->hasTable('todos')) {
    Manager::schema()->create('todos', function(Blueprint $table) {
        $table->id();
        $table->string('text');
        $table->boolean('done');
        $table->timestamps();
    });
}
