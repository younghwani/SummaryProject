import axios from 'axios';
import React, { useState, useEffect } from 'react';

const Result = ({ match }) => {
	const [data, setData] = useState('');
	const [isLoading, setIsLoading] = useState(true);

	let input = match.params.input;

	const getSummarizedText = async () => {
		try {
			const response = await axios.get(
				`http://localhost:8080/api/summary?text=${input}`
			);
			setData(response.data);
		} catch (e) {
			console.log(e);
		}
		setIsLoading(false);
	};

	const mainPageBtnClick = () => {
		window.location.href = '/';
	};

	// eslint-disable-next-line react-hooks/exhaustive-deps
	useEffect(() => {
		getSummarizedText();
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, []);

	return (
		<div className="resultContainer">
			{isLoading ? (
				<div className="loader">
					<span className="loader__text">Loading...</span>
				</div>
			) : (
				<div>
					<button onClick={mainPageBtnClick}>Main Page</button>
					<h1>Result</h1>
					<div>
						<h2>Input</h2>
						<p>{data.input}</p>
					</div>
					<div>
						<h2>Output</h2>
						<p>{data.output}</p>
					</div>
				</div>
			)}
		</div>
	);
};

export default Result;
