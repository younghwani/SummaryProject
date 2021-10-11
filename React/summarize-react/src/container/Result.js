import React from 'react';

const Result = ({ match }) => {
	let result = match.params.result;

	const mainPageBtnClick = () => {
		window.location.href = '/';
	};

	return (
		<div className="resultContainer">
			<div>
				<button onClick={mainPageBtnClick}>Main Page</button>
				<h1>Result</h1>
				<div>
					<h2>Output</h2>
					<p>{result}</p>
				</div>
			</div>
		</div>
	);
};

export default Result;
