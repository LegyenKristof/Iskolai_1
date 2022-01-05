<?php

namespace Petrik\Todolist15wl;

use Illuminate\Database\Eloquent\Model;

class Todo extends Model {
    protected $fillable = ['text', 'done'];
}

