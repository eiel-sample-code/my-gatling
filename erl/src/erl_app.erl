-module(erl_app).
-behaviour(application).

-export([start/2]).
-export([stop/1]).

start(_Type, _Args) ->
    Dispatch = cowboy_router:compile([
        {'_', [{"/", hello_handler, []}]}
    ]),
    {ok, _} = cowboy:start_clear(my_http_listener, 100,
        [{port, 80}],
        #{env => #{dispatch => Dispatch}}
    ),
    erl_sup:start_link().

stop(_State) ->
	ok.
