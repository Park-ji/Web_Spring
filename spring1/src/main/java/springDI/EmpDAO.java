package springDI;

public class EmpDAO {
	//사원 정보가 DB나 FILE에 존재한다고 가정	
	EmpVO vo;

	public EmpVO getVo() {
		return vo;
	}

	public void setVo(EmpVO vo) {
		this.vo = vo;
	}
	
}
