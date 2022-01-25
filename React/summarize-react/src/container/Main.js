import axios from 'axios';
import React, { useState } from 'react';
import './Main.css';
import { Container, Form, FormGroup, Input, Label, Button } from 'reactstrap';

const Main = () => {
	const [input, setInput] = useState('');
	const [isLoading, setIsLoading] = useState(false);
	const [isKor, setIsKor] = useState(true);

	let output = '';

	function onInputChange(event) {
		const target = event.target;
		const value = target.value;
		setInput(value);
	}

	const handleSubmitEn = async (event) => {
		event.preventDefault();
		setIsLoading(true);
		const data = await axios.get(
			`http://localhost:8080/api/summary?text=${input}`
		);
		output = data.data.output;
		console.log(output);
		setIsLoading(false);
		window.location.href = `/result/${output}`;
	};

	const handleSubmitKor = async (event) => {
		event.preventDefault();
		setIsLoading(true);
		const data = await axios.get(
			`http://localhost:8080/api/kobartSum?text=${input}`
		);
		output = data.data.output;
		console.log(output);
		setIsLoading(false);
		window.location.href = `/result/${output}`;
	};

	function handleKeyPress(target) {
		if (target.charCode === 13) {
			alert('Enter clicked!!!');
		}
	}

	function btnClickKo() {
		if (!isKor) {
			setInput('');
			document.getElementById('input').value = '';
		}
		setIsKor(true);
	}
	function btnClickEn() {
		if (isKor) {
			setInput('');
			document.getElementById('input').value = '';
		}
		setIsKor(false);
	}

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
			<div className="contentsContainer">
				<div className="desc">
					<h1>KoBART 요약</h1>
					<h3>지금 사용해보세요!!</h3>
				</div>
				{isLoading ? (
					<div className="runningMsg">
						<h2>요약 중입니다.</h2>
						<p>잠시 후 결과창으로 이동합니다.</p>
					</div>
				) : (
					<Container className="formContainer">
						<div class="btns">
							<button class="btn1" onClick={btnClickKo}>
								한글 요약
							</button>
							<button class="btn2" onClick={btnClickEn}>
								영어 요약
							</button>
						</div>
						<br />
						{isKor ? (
							<div>
								<Form onSubmit={handleSubmitKor}>
									<Label for="input">
										요약할 텍스트를 입력해주세요 (한글만)!!
									</Label>
									<br />
									<Input
										className="input__text"
										type="text"
										name="input"
										id="input"
										onChange={onInputChange}
										onKeyPress={handleKeyPress}
										placeholder="한글 텍스트를 입력"
									/>
									<br />
									<br />
									<FormGroup className="resultBtn">
										<Button color="success" type="submit">
											요약하기
										</Button>{' '}
										<Button color="danger" href={`/`}>
											취소
										</Button>
									</FormGroup>
								</Form>
							</div>
						) : (
							<div>
								<Form onSubmit={handleSubmitEn}>
									<Label for="input">
										Input text (only english)!!
									</Label>
									<br />
									<Input
										className="input__text"
										type="text"
										name="input"
										id="input"
										onChange={onInputChange}
										placeholder="Input text.."
									/>
									<br />
									<br />
									<FormGroup className="resultBtn">
										<Button color="success" type="submit">
											요약하기
										</Button>{' '}
										<Button color="danger" href={`/`}>
											취소
										</Button>
									</FormGroup>
								</Form>
							</div>
						)}
						<br />
						<br />
					</Container>
				)}
			</div>
		</div>
	);
};

export default Main;
