import './App.css';

import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';

import Main from './container/Main';
// import About from './container/About';
import Result from './container/Result';

export default function App() {
	return (
		<Router>
			<div>
				<Route path="/" component={Main} />
				<Route exact path="/result/:result" component={Result} />
				{/* <Route exact path="/about" component={About} /> */}
			</div>
		</Router>
	);
}
