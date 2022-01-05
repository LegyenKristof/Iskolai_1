(this.webpackJsonptodolist=this.webpackJsonptodolist||[]).push([[0],{14:function(t,e,n){},15:function(t,e,n){},18:function(t,e,n){},19:function(t,e,n){"use strict";n.r(e);var o=n(1),a=n.n(o),r=n(9),s=n.n(r),c=(n(14),n.p,n(15),n(2)),i=n.n(c),d=n(7),u=n(3),h=n(4),l=n(6),j=n(5),p=n(0),b=function(t){Object(l.a)(n,t);var e=Object(j.a)(n);function n(){var t;Object(u.a)(this,n);for(var o=arguments.length,a=new Array(o),r=0;r<o;r++)a[r]=arguments[r];return(t=e.call.apply(e,[this].concat(a))).handleCheckboxChange=function(e){var n=t.props.onChange;n&&n(e.target.checked)},t}return Object(h.a)(n,[{key:"render",value:function(){var t=this.props,e=t.done,n=t.text;return Object(p.jsxs)(p.Fragment,{children:[Object(p.jsx)("input",{type:"checkbox",checked:e,onChange:this.handleCheckboxChange}),Object(p.jsx)("span",{children:n})]})}}]),n}(a.a.Component),x=(n(18),function(t){Object(l.a)(n,t);var e=Object(j.a)(n);function n(t){var o;return Object(u.a)(this,n),(o=e.call(this,t)).loadData=Object(d.a)(i.a.mark((function t(){var e,n;return i.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return o.setState({loading:!0,errorMessage:null}),t.prev=1,t.next=4,fetch("http://localhost:8080/todos");case 4:if((e=t.sent).ok){t.next=7;break}throw Error(e.statusText);case 7:return t.next=9,e.json();case 9:n=t.sent,o.setState({todos:n.map((function(t){return{id:t.id,text:t.text,done:1==t.done}})),loading:!1,errorMessage:null}),t.next=16;break;case 13:t.prev=13,t.t0=t.catch(1),o.setState({errorMessage:t.t0.message});case 16:case"end":return t.stop()}}),t,null,[[1,13]])}))),o.handleTodoDone=function(){var t=Object(d.a)(i.a.mark((function t(e,n){var a;return i.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return(a=Array.from(o.state.todos))[e]={id:a[e].id,text:a[e].text,done:n},t.next=4,fetch("http://localhost:8080/todos/"+a[e].id,{method:"PUT",headers:{"Content-Type":"application/json"},body:JSON.stringify(a[e])});case 4:t.sent.ok&&o.setState({todos:a});case 6:case"end":return t.stop()}}),t)})));return function(e,n){return t.apply(this,arguments)}}(),o.handleNewTodoChange=function(t){var e=t.target.value;o.setState({newTodo:e})},o.handleNewTodoClick=Object(d.a)(i.a.mark((function t(){var e,n,a,r,s,c,d;return i.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:if(e=o.state,n=e.newTodo,a=e.todos,""!==n.trim()){t.next=3;break}return t.abrupt("return");case 3:return r={text:n.trim(),done:!1},t.next=6,fetch("http://localhost:8080/todos",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(r)});case 6:if(!(s=t.sent).ok){t.next=14;break}return t.next=10,s.json();case 10:c=t.sent,(d=Array.from(a)).push(c),o.setState({todos:d,newTodo:""});case 14:case"end":return t.stop()}}),t)}))),o.state={errorMessage:null,loading:!0,newTodo:"",todos:[]},o}return Object(h.a)(n,[{key:"componentDidMount",value:function(){this.loadData()}},{key:"render",value:function(){var t=this;return this.state.errorMessage?Object(p.jsxs)("div",{className:"error",children:[this.state.errorMessage,Object(p.jsx)("br",{}),Object(p.jsx)("button",{onClick:this.loadData,children:"Reload"})]}):this.state.loading?Object(p.jsx)("div",{children:"Loading..."}):Object(p.jsxs)("div",{children:[Object(p.jsxs)("div",{children:[Object(p.jsx)("input",{type:"text",value:this.state.newTodo,onInput:this.handleNewTodoChange}),Object(p.jsx)("button",{onClick:this.handleNewTodoClick,children:"Add"})]}),Object(p.jsx)("ul",{className:"TodoList",children:this.state.todos.map((function(e,n){return Object(p.jsx)("li",{children:Object(p.jsx)(b,{text:e.text,done:e.done,onChange:function(e){return t.handleTodoDone(n,e)}})})}))})]})}}]),n}(a.a.Component));var f=function(){return Object(p.jsx)("div",{className:"App",children:Object(p.jsx)(x,{})})},O=function(t){t&&t instanceof Function&&n.e(3).then(n.bind(null,20)).then((function(e){var n=e.getCLS,o=e.getFID,a=e.getFCP,r=e.getLCP,s=e.getTTFB;n(t),o(t),a(t),r(t),s(t)}))};s.a.render(Object(p.jsx)(a.a.StrictMode,{children:Object(p.jsx)(f,{})}),document.getElementById("root")),O()}},[[19,1,2]]]);
//# sourceMappingURL=main.f6936c7c.chunk.js.map