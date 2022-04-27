const isValid = function (s) {
	// 1. 파라미터를 반복하면서 파라미터의 문자열이 열린 괄호들이 있는지 먼저 확인한다. -> indexOf를 활용하여 해당
	while (
		s.indexOf('()') !== -1 ||
		s.indexOf('{}') !== -1 ||
		s.indexOf('[]') !== -1
	) {
		// 2. 열린 괄호가 있다면 하나씩 삭제한다.
		s = s.replace('()', '').replace('{}', '').replace('[]', '');
	}

	// 3. 아무것도 없으면 true를 반환한다.
	return !s.length;
};
