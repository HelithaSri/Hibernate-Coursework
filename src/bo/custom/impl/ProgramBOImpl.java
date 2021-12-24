package bo.custom.impl;

import bo.custom.ProgramBO;
import dao.DAOFactory;
import dto.ProgramDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 11:32 PM
 * @project HibernateCW
 */
public class ProgramBOImpl implements ProgramBO {
    private final ProgramBOImpl programBOImpl = (ProgramBOImpl) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.PROGRAM);

    @Override
    public boolean add(ProgramDTO programDTO) {
        return programBOImpl.add(new ProgramDTO(
                programDTO.getProgramId(),
                programDTO.getProgramName(),
                programDTO.getDuration(),
                programDTO.getFee()
        ));
    }

    @Override
    public List<ProgramDTO> find() {
        List<ProgramDTO> list = programBOImpl.find();
        ArrayList<ProgramDTO> dtoArrayList = new ArrayList<>();
        ProgramDTO programDTO = null;

        for (ProgramDTO program : list) {
            dtoArrayList.add(new ProgramDTO(
                program.getProgramId(),
                program.getProgramName(),
                program.getDuration(),
                program.getFee()
            ));
        }
        return dtoArrayList;
    }

    @Override
    public boolean delete(String id) {
        return programBOImpl.delete(id);
    }

    @Override
    public boolean update(ProgramDTO programDTO) {
        return programBOImpl.update(new ProgramDTO(
                programDTO.getProgramId(),
                programDTO.getProgramName(),
                programDTO.getDuration(),
                programDTO.getFee()
        ));
    }
}
