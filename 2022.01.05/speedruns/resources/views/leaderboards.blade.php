<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        td, th, table {
            border: solid black 1px;
        }
        td, th {
            padding: 10px;
        }
        html{
            font-family: Arial, Helvetica, sans-serif;
        }
    </style>
</head>
<body>
    <h1>Speedrun leaderboards</h1>
    <table>
        <tr>
            <th>Game title</th>
            <th>Category</th>
            <th>Time (sec)</th>
            <th>Runner</th>
        </tr>
        @foreach($records as $record)
        <tr>
            <td>{{$record->game->name}}</td>
            <td>{{$record->category}}</td>
            <td>{{$record->time}}</td>
            <td>{{$record->user->name}}</td>
        </tr>
        @endforeach
    </table>
</body>
</html>
