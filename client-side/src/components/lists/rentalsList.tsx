import {Datagrid, EditButton, List, TextField} from 'react-admin'

export const RentalsList = () => (
	<List>
		<Datagrid rowClick='show'>
			<TextField source='id' />
			<TextField source='username' />
			<TextField source='movietitle' />
			<TextField source='rental_date' />
			<TextField source='return_date' />
			<TextField source='status' />
			<EditButton label='Edit' />
		</Datagrid>
	</List>
)
