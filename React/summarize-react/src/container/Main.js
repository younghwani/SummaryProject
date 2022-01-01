import axios from 'axios';
import React, { useState } from 'react';
import { Container, Form, FormGroup, Input, Label, Button } from 'reactstrap';

const Main = () => {
	const [input, setInput] = useState('');
	const [isLoading, setIsLoading] = useState(false);

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

	return (
		<div className="mainContainer">
			<div>
				<h1>Main</h1>
				<h3>요약 테스트</h3>
			</div>
			{isLoading ? (
				<div>
					<h2>요약 중입니다.</h2>
					<p>잠시 후 결과창으로 이동합니다.</p>
				</div>
			) : (
				<Container>
					<h2>영어 요약을 위한 텍스트를 입력해주세요.</h2>
					<Form onSubmit={handleSubmitEn}>
						<Label for="input">
							요약할 텍스트를 입력해주세요!!
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
						<FormGroup>
							<Button color="success" type="submit">
								요약하기
							</Button>{' '}
							<Button color="danger" href={`/`}>
								취소
							</Button>
						</FormGroup>
					</Form>
					<br />
					<br />
					<h2>한글 요약을 위한 텍스트를 입력해주세요.</h2>
					<Form onSubmit={handleSubmitKor}>
						<Label for="input">
							요약할 텍스트를 입력해주세요!!
						</Label>
						<br />
						<Input
							className="input__text"
							type="text"
							name="input"
							id="input"
							onChange={onInputChange}
							placeholder="한글 텍스트를 입력"
						/>
						<br />
						<br />
						<FormGroup>
							<Button color="success" type="submit">
								요약하기
							</Button>{' '}
							<Button color="danger" href={`/`}>
								취소
							</Button>
						</FormGroup>
					</Form>
				</Container>
			)}
		</div>
	);
};

export default Main;
