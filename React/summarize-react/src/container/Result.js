import React from 'react';
import Footer from './Footer';
import Header from './Header';
import { Button } from 'reactstrap';
import './Result.css';

const Result = ({ match }) => {
	let result = match.params.result;

	const mainPageBtnClick = () => {
		window.location.href = '/';
	};

	return (
		<div className="mainContainer">
			<video
				class="bg-video"
				playsinline="playsinline"
				autoplay="autoplay"
				muted="muted"
				loop="loop"
				src="https://github.com/younghwani/temp/blob/master/sunrise.mp4?raw=true"
				type="video/mp4"
			></video>
			<div className="resultContainer">
				<Header />
				<div className="summary">
					<div className="contents">
						<h2>요약 결과</h2>
						<p>{result}</p>
					</div>
					<div className="backBtn">
						<Button color="primary" onClick={mainPageBtnClick}>
							Back
						</Button>
					</div>
				</div>
			</div>
			<Footer />
		</div>
	);
};

export default Result;
